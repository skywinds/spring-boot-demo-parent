package com.sas.sbdth.controller;

import com.sas.sbdth.model.ProductInfo;
import com.sas.sbdth.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping(value = "/products")
    public String handleList(ProductInfo info, Model model) {
        model.addAttribute("list", productService.findByPage(info));
        return "product/list";
    }


    @GetMapping(value = "/product/{id}")
    public String handleDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("detail", productService.getProduct(id));
        return "product/detail";
    }
}
