package com.supera.DesafioTecnico.dto.filter;

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
public class FilterFindProduct {

    private String name;
    private Double minPrice;
    private Double maxPrice;
    private String categoryKey;

}
