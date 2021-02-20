package ru.geekbrains.katebatasheva.spring.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.katebatasheva.spring.model.Product;
import ru.geekbrains.katebatasheva.spring.service.ProductService;

import java.util.HashSet;

@org.springframework.stereotype.Controller
@RequestMapping ("/products")
public class Controller {

ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products/all";
    }
    @PostMapping("/{id}/update")
    public String updateProductById(@PathVariable Integer id, @ModelAttribute Integer newCost) {
        productService.update(id,newCost);
        return "redirect:/products/all";
    }

}
