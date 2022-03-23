package com.pt.controller;

import com.pt.model.Board;
import com.pt.model.Paging;
import com.pt.model.dto.BoardSearch;
import com.pt.model.FileDTO;
import com.pt.model.Users;
import com.pt.repository.BoardRepository;
import com.pt.service.BoardService;
import com.pt.service.CommonService;
import com.pt.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
@Log
public class BoardController {
    private final FileService fileService;
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final CommonService<Board> commonService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size=9) Pageable pageable) throws Exception{
        Page<Board> boards = boardService.list(pageable);
        model.addAttribute("boards" , boards);
        model.addAttribute("pageRange", commonService.pageRange(boards));
        return "board/list";
    }

    @GetMapping("/insert")
    public String insert() {
        return "board/insert";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam MultipartFile[] uploadFile, Board board, @AuthenticationPrincipal Users user) throws IllegalStateException, IOException {
        if(user == null) {
            return "board/insert";
        }
        board.setUser(user);

        for(MultipartFile multipartFile: uploadFile) {
            FileDTO fileDTO = fileService.fileValidation(multipartFile, "jpg", "png");
            if (fileDTO != null) {
                File file = new File(fileDTO.getPath() + fileDTO.getFilename());
                multipartFile.transferTo(file);
                board.addFile(fileDTO);
                fileDTO.setBoard(board);
            }
        }
        boardRepository.save(board);

        return "board/insert";
    }

    @GetMapping("/view")
    public String view(@RequestParam Long id, Model model){
        Board board = boardRepository.findById(id).get();
        model.addAttribute("board" , board);
        return "/board/view";
    }

}
