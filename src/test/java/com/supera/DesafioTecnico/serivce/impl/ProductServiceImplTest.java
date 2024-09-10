package com.supera.DesafioTecnico.serivce.impl;

import com.supera.DesafioTecnico.dto.filter.FilterFindProduct;
import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;
import com.supera.DesafioTecnico.entity.Category;
import com.supera.DesafioTecnico.entity.Product;
import com.supera.DesafioTecnico.repository.CategoryRepository;
import com.supera.DesafioTecnico.repository.ProductRepository;
import com.supera.DesafioTecnico.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_ShouldReturnProductOutput_WhenProductIsCreated() {
        ProductInput productInput = ProductInput.builder()
                .name("Product Name")
                .categoryKey("CategoryKey")
                .description("Description")
                .price(100.00)
                .build();

        Category category = Category.builder()
                .name("Category Name")
                .keyword("CategoryKey")
                .build();

        Product product = Product.builder()
                .name(productInput.getName())
                .price(productInput.getPrice())
                .description(productInput.getDescription())
                .category(category)
                .build();

        when(categoryRepository.findByKeyword(productInput.getCategoryKey()))
                .thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class)))
                .thenReturn(product);

        ProductOutput productOutput = productService.create(productInput);

        assertNotNull(productOutput);
        assertEquals(productInput.getName(), productOutput.getName());

        verify(categoryRepository).findByKeyword(productInput.getCategoryKey());
        verify(productRepository).save(any(Product.class));
        verify(productRepository, times(1)).save(any(Product.class));

    }

    @Test
    void findByFilterProduct_ShouldReturnFilteredProducts() {

        FilterFindProduct filter = FilterFindProduct.builder()
                .categoryKey("categoryKey")
                .minPrice(50.00)
                .maxPrice(100.00)
                .build();

        Category category = Category.builder()
                .name("Category Name")
                .keyword("CategoryKey")
                .build();

        Product product1 = Product.builder()
                .name("Product 1")
                .price(65.50)
                .description("Description 1")
                .category(category)
                .build();

        Product product2 = Product.builder()
                .name("Product 2")
                .price(98.90)
                .description("Description 2")
                .category(category)
                .build();


        List<Product> products = List.of(product1, product2);

        when(productRepository.findAllByFilter(filter)).thenReturn(products);

        List<ProductOutput> productOutputs = productService.findByFilterProduct(filter);

        assertNotNull(productOutputs);
        assertEquals(2, productOutputs.size());
        verify(productRepository).findAllByFilter(filter);
    }

}
