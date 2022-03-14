package com.pt.controller;

import com.pt.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public String list(){
        return "board/list";
    }
}
