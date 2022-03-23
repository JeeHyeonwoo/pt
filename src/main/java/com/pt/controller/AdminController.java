package com.pt.controller;

import com.pt.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/main")
    public String goMain(@AuthenticationPrincipal Users users) {
        boolean result = false;

        for(GrantedAuthority role : users.getAuthorities()) {
            if(role.getAuthority().equals("ROLE_ADMIN")){
                result = true;
                return "/admin/main";
            }
        }
        return "/index";
    }

}
