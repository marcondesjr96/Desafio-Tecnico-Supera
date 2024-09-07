package com.supera.DesafioTecnico.controller;

import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;
import com.supera.DesafioTecnico.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductOutput create(@Valid @RequestBody ProductInput productInput){
        return productService.create(productInput);
    }

    @PostMapping("/list")
    public List<ProductOutput> saveList (@RequestBody List<ProductInput> productInputList){
        return productService.saveList(productInputList);
    }
}


