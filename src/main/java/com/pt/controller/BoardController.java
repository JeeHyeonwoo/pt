package com.pt.controller;

import com.pt.model.Board;
import com.pt.model.FileDTO;
import com.pt.model.Users;
import com.pt.repository.BoardRepository;
import com.pt.repository.UserRepository;
import com.pt.service.BoardService;
import com.pt.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
    private final UserRepository userRepository;
    private final FileService fileService;
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request){
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
    public String view(@PathVariable Long id){
        return "/board/view";
    }

}
