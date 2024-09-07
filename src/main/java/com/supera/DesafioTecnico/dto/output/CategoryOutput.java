package com.supera.DesafioTecnico.dto.output;

import com.supera.DesafioTecnico.entity.Category;
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
public class CategoryOutput {

    private String name;
    private String keyword;
    private StatusEnum status;

    public static CategoryOutput toOutput(Category category){
        return CategoryOutput.builder()
                .name(category.getName())
                .keyword(category.getKeyword())
                .status(category.getStatus())
                .build();
    }
}
