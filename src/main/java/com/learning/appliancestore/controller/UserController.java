package com.learning.appliancestore.controller;

import com.learning.appliancestore.repository.RoleRepository;
import com.learning.appliancestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ivanov on 24.3.2018 г..
 */
@Controller
public class UserController {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("view", "user/register");

        return "home/index";
    }
}
