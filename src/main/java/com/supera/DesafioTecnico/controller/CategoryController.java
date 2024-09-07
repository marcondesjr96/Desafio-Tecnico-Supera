package com.supera.DesafioTecnico.controller;

import com.supera.DesafioTecnico.dto.input.CategoryInput;
import com.supera.DesafioTecnico.dto.output.CategoryOutput;
import com.supera.DesafioTecnico.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryOutput create(@RequestBody CategoryInput categoryInput) {
        return categoryService.create(categoryInput);
    }

}
