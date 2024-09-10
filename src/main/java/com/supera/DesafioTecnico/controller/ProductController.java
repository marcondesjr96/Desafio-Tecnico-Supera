package com.supera.DesafioTecnico.controller;

import com.supera.DesafioTecnico.dto.input.ProductPriorityUpdateDTO;
import com.supera.DesafioTecnico.dto.input.ProductStatusUpdateDTO;
import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;
import com.supera.DesafioTecnico.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ProductOutput create(@Valid @RequestBody ProductInput productInput) {
        return productService.create(productInput);
    }

    @PostMapping("/list")
    public List<ProductOutput> saveList(@RequestBody List<ProductInput> productInputList) {
        return productService.saveList(productInputList);
    }

    @PutMapping("/list/status")
    public List<ProductOutput> updateStatusList(@RequestBody List<ProductStatusUpdateDTO> updates) {
        return productService.updateStatusList(updates);
    }

    @PutMapping("/list/priority")
    public List<ProductOutput> updatePriorityList(@RequestBody List<ProductPriorityUpdateDTO> updates) {
        return productService.updatePriorityList(updates);
    }

    @GetMapping("/list/ordered-by-priority/category/{categoryKey}")
    public List<ProductOutput> findAllOrderedByPriority(@PathVariable String categoryKey) {
        return productService.findAllOrderedByPriority(categoryKey);
    }
}


