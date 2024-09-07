package com.supera.DesafioTecnico.controller;

import com.supera.DesafioTecnico.entity.Product;
import com.supera.DesafioTecnico.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(Product product){
        return productService.create(product);
    }
}


