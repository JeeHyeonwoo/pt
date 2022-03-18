package com.pt.controller;

import com.pt.model.Board;
import com.pt.model.FileDTO;
import com.pt.model.Users;
import com.pt.repository.BoardRepository;
import com.pt.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
@Log
public class BoardController {
    private final FileService fileService;
    private final BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model, Pageable pageable){
        List<Board> boards = boardRepository.findAll(pageable).getContent();

        model.addAttribute("boards" , boards);

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
