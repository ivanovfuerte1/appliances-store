package com.learning.appliancestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ivanov on 18.3.2018 г..
 */
//@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }
}
