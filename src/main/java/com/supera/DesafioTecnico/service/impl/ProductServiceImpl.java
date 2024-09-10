package com.supera.DesafioTecnico.service.impl;

import com.supera.DesafioTecnico.dto.filter.FilterFindProduct;
import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.input.ProductPriorityUpdateDTO;
import com.supera.DesafioTecnico.dto.input.ProductStatusUpdateDTO;
import com.supera.DesafioTecnico.dto.output.ProductOutput;
import com.supera.DesafioTecnico.entity.Category;
import com.supera.DesafioTecnico.entity.Product;
import com.supera.DesafioTecnico.repository.CategoryRepository;
import com.supera.DesafioTecnico.repository.ProductRepository;
import com.supera.DesafioTecnico.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    @Transactional
    public List<ProductOutput> updateStatusList(List<ProductStatusUpdateDTO> updates) {
        List<Product> updatedProducts = new ArrayList<>();
        for (ProductStatusUpdateDTO updateDTO : updates) {
            Product updatedProduct = updateStatusProduct(updateDTO);
            updatedProducts.add(updatedProduct);
        }

        List<Product> savedProducts = productRepository.saveAll(updatedProducts);

        return savedProducts.stream()
                .map(ProductOutput::toOutput)
                .toList();
    }

    @Override
    public List<ProductOutput> findAllOrderedByPriority(String categoryKey) {
        List<Product> orderedProducts = productRepository.findAllOrderedByPriorityAndCategoryKeyword(categoryKey.toUpperCase());
        return orderedProducts.stream().map(ProductOutput::toOutput).toList();
    }

    @Override
    public List<ProductOutput> updatePriorityList(List<ProductPriorityUpdateDTO> updates) {
        List<Product> updatedProducts = new ArrayList<>();
        for (ProductPriorityUpdateDTO updateDTO : updates) {
            Product updatedProduct = updatePriorityProduct(updateDTO);
            updatedProducts.add(updatedProduct);
        }

        List<Product> savedProducts = productRepository.saveAll(updatedProducts);

        return savedProducts.stream()
                .map(ProductOutput::toOutput)
                .toList();
    }

    @Override
    public List<ProductOutput> findByFilterProduct(FilterFindProduct filterFindProduct) {
        List<Product> filteredProducts = productRepository.findAllByFilter(filterFindProduct);
        return filteredProducts.stream()
                .map(ProductOutput::toOutput)
                .toList();
    }

    private Product updatePriorityProduct(ProductPriorityUpdateDTO updateDTO) {
        Product product = productRepository.findById(updateDTO.getProductId()).orElseThrow(RuntimeException::new);
        product.setPriority(updateDTO.getPriority());
        return product;
    }

    private Product updateStatusProduct(ProductStatusUpdateDTO updateDTO) {
        Product product = productRepository.findById(updateDTO.getProductId()).orElseThrow(RuntimeException::new);
        product.setStatus(updateDTO.getStatus());
        return product;
    }

    private Product createProduct(ProductInput productInput) {
        validateName(productInput);
        Product product = ProductInput.toEntity(productInput);
        Category category = categoryRepository.findByKeyword(productInput.getCategoryKey()).orElseThrow(RuntimeException::new);
        product.setCategory(category);
        return product;
    }

    private void validateName(ProductInput productInput) {
        if (productInput.getName().length() > 15) {
            throw new RuntimeException("Name exceeds the maximum number of 15 characters");
        }
    }
}
