package com.learning.appliancestore.controller;

import com.learning.appliancestore.bindingmodel.SaleBindingModel;
import com.learning.appliancestore.entity.Sale;
import com.learning.appliancestore.repository.SaleRepository;
import com.learning.appliancestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanov on 1.4.2018 г..
 */
@Controller
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sale/display")
    @PreAuthorize("isAuthenticated()")
    public String display(Model model){
        model.addAttribute("view", "sale/display");

        return "base-layout";
    }

    @GetMapping("sale/all-sales")
    @PreAuthorize("isAuthenticated()")
    public String listSales(Model model){
        List<Sale> sales = saleRepository.findAll();
        List<SaleBindingModel> bindingModels = new ArrayList<>();
        for (Sale sale : sales) {
            SaleBindingModel currentModel = new SaleBindingModel();
            currentModel.setId(sale.getId().toString());
            currentModel.setDiscount(sale.getDiscount().toString());
            bindingModels.add(currentModel);
        }
        model.addAttribute("sales", bindingModels);
        model.addAttribute("view", "sale/all-sales");

        return "base-layout";
    }
}
