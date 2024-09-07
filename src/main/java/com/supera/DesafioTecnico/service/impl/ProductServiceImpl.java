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

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public ProductOutput create(ProductInput productInput) {
        Product product = createProduct(productInput);
        return ProductOutput.toOutput(productRepository.save(product));
    }

    @Override
    public List<ProductOutput> saveList(List<ProductInput> productInputs) {
        for (ProductInput productInput : productInputs) {
            validateName(productInput);
        }
        List<Product> products = productInputs.stream()
                .map(this::createProduct)
                .toList();
        List<Product> savedProducts = productRepository.saveAll(products);

        return savedProducts.stream()
                .map(ProductOutput::toOutput)
                .toList();
    }

    private Product createProduct (ProductInput productInput){
        validateName(productInput);
        Product product = ProductInput.toEntity(productInput);
        Category category = categoryRepository.findByKeyword(productInput.getCategoryKey()).orElseThrow(RuntimeException::new);
        product.setCategory(category);
        return product;
    }

    private void validateName(ProductInput productInput) {
        if(productInput.getName().length() > 15){
            throw new RuntimeException("Name exceeds the maximum number of 15 characters");
        }
    }
}
