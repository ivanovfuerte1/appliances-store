package com.learning.appliancestore.controller;

import com.learning.appliancestore.entity.Appliance;
import com.learning.appliancestore.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ivanov on 18.3.2018 г..
 */
@Controller
public class HomeController {

    @Autowired
    private ApplianceRepository applianceRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("view", "home/index");
        List<Appliance> appliances = applianceRepository.findAll();
        model.addAttribute("appliances", appliances);
        return "base-layout";
    }

    @RequestMapping("/error/403")
    public String accessDenied(Model model){
        model.addAttribute("view", "error/403");

        return "base-layout";
    }

    @GetMapping("/basket/show")
    public String listAppliances(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Set<Integer> applianceIds = (Set<Integer>) session.getAttribute("selectedAppliances");
        Set<String> appliancePaths = new HashSet<>();
        for (Integer id : applianceIds) {
            Appliance appliance = applianceRepository.findById(id).get();
            appliancePaths.add(appliance.getImagePath());
        }
        model.addAttribute("appliancePaths", appliancePaths);
        model.addAttribute("view", "/basket/show");


        return "base-layout";
    }
}
