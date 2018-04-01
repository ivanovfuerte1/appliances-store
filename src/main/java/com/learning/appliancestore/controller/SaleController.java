package com.learning.appliancestore.controller;

import com.learning.appliancestore.repository.SaleRepository;
import com.learning.appliancestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ivanov on 1.4.2018 г..
 */
@Controller
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sale/create")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model){
        model.addAttribute("view", "sale/create");

        return "base-layout";
    }
}
