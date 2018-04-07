package com.learning.appliancestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivanov on 7.4.2018 г..
 */
@Controller
public class ApplianceController {
    @GetMapping("/basket/add/{id}")
    public String addToBasket(@PathVariable Integer id, HttpServletRequest request){
        HttpSession session = request.getSession();
        Set<Integer> selectedAppliances = (Set<Integer>) session.getAttribute("selectedAppliances");
        if(selectedAppliances == null){
            selectedAppliances = new HashSet<>();
        }
        selectedAppliances.add(id);
        session.setAttribute("selectedAppliances", selectedAppliances);
        return "redirect:/";
    }
}
