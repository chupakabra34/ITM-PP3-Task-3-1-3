package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    public String homePage() {
        return "login";
    }
}