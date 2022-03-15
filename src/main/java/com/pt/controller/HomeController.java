package com.pt.controller;

import com.pt.model.Users;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@AuthenticationPrincipal Users users){
        return "index";
    }

}
