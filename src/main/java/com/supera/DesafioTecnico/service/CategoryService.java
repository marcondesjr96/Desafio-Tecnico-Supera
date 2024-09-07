package com.supera.DesafioTecnico.service;

import com.supera.DesafioTecnico.dto.input.CategoryInput;
import com.supera.DesafioTecnico.dto.output.CategoryOutput;

public interface CategoryService {

    CategoryOutput create(CategoryInput categoryInput);
}
