package com.supera.DesafioTecnico.service.impl;

import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;
import com.supera.DesafioTecnico.entity.Category;
import com.supera.DesafioTecnico.entity.Product;
import com.supera.DesafioTecnico.repository.CategoryRepository;
import com.supera.DesafioTecnico.repository.ProductRepository;
import com.supera.DesafioTecnico.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public ProductOutput create(ProductInput productInput) {
        if(productInput.getName().length() > 15){
            throw new RuntimeException("Name exceeds the maximum number of 15 characters");
        }
        Product product = ProductInput.toEntity(productInput);
        Category category = categoryRepository.findByKeyword(productInput.getCategoryKey()).orElseThrow(RuntimeException::new);
        product.setCategory(category);
        return ProductOutput.toOutput(productRepository.save(product));
    }
}
