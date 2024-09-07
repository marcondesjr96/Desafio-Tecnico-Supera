package com.supera.DesafioTecnico.service.impl;

import com.supera.DesafioTecnico.entity.Category;
import com.supera.DesafioTecnico.repository.CategoryRepository;
import com.supera.DesafioTecnico.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }
}
