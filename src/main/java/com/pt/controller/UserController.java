package com.pt.controller;

import com.pt.model.Users;
import com.pt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "/signup";
    }

    @PostMapping("/signup")
    public String signup(Model model, Users user){
        try {
            System.out.println(user.getUsername() +"\n"+ user.getPassword());
            userService.save(user);
        }catch (Exception e){
            model.addAttribute("user", user);
            model.addAttribute("message", "이미 존재하는 아이디가 있습니다");
            return "redirect:/user/signup";
        }
        return "redirect:/";
    }
}
