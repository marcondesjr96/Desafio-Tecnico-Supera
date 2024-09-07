package com.supera.DesafioTecnico.dto.input;

import com.supera.DesafioTecnico.entity.Product;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductInput {

    @Size(max = 15, message = "Name exceeds the maximum number of 15 characters")
    private String name;
    private String description;
    private Double price;
    private String categoryKey;

    public static Product toEntity(ProductInput productInput) {
        return Product.builder()
                .name(productInput.getName())
                .description(productInput.getDescription())
                .price(productInput.getPrice())
                .build();
    }
}
