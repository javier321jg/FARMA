
package com.example.plan.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "login";
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "index";
    }
}
