package com.pt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("/chat")
    public void chat(Model model) {
        model.addAttribute("userId", "게스트1");
    }
}
