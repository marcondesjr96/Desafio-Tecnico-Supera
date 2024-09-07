package com.supera.DesafioTecnico.service.impl;

import com.supera.DesafioTecnico.entity.Product;
import com.supera.DesafioTecnico.repository.ProductRepository;
import com.supera.DesafioTecnico.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
