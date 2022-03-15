package com.pt.controller;

import com.pt.model.Board;
import com.pt.model.FileDTO;
import com.pt.service.BoardService;
import com.pt.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
    private final FileService fileService;
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request){
        return "board/list";
    }

    @GetMapping("/insert")
    public String insert() {
        return "board/insert";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam MultipartFile[] uploadFile, Board board, Model model) throws IllegalStateException, IOException {

        /*List<FileDTO> fileDTOList = fileService.fileSave(uploadFile, "jpg", "png").get();
        if(fileDTOList != null) {

        }*/

        return "board/insert";
    }

    @GetMapping("/view")
    public String view(@PathVariable Long id){
        return "/board/view";
    }

}
