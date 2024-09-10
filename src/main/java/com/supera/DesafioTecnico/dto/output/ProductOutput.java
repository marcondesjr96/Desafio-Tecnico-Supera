package com.supera.DesafioTecnico.dto.output;

import com.supera.DesafioTecnico.entity.Product;
import com.supera.DesafioTecnico.entity.enums.PriorityEnum;
import com.supera.DesafioTecnico.entity.enums.StatusEnum;
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
public class ProductOutput {

    private String name;
    private String description;
    private Double price;
    private StatusEnum statusEnum;
    private String categoryName;
    private PriorityEnum priority;

    public static ProductOutput toOutput(Product product) {
        return ProductOutput.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .statusEnum(product.getStatus())
                .categoryName(product.getCategory().getName())
                .priority(product.getPriority())
                .build();
    }
}
