package com.supera.DesafioTecnico.dto.input;

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

    private String name;
    private String description;
    private Double price;
    private String categoryKey;
}
