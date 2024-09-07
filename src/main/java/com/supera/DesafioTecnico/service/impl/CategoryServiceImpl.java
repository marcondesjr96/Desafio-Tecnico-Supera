package com.supera.DesafioTecnico.service.impl;

import com.supera.DesafioTecnico.dto.input.CategoryInput;
import com.supera.DesafioTecnico.dto.output.CategoryOutput;
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
    public CategoryOutput create(CategoryInput categoryInput) {
        Category category = CategoryInput.toEntity(categoryInput);
        return CategoryOutput.toOutput(categoryRepository.save(category));

    }
}
