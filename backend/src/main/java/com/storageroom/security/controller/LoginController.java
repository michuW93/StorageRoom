package com.storageroom.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/user")
    public String userPanel() {
        return "userPanel";
    }

    @PostMapping("/admin")
    public String adminPanel() {
        return "adminPanel";
    }
}
