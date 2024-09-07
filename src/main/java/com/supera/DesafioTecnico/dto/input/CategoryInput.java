package com.supera.DesafioTecnico.dto.input;

import com.supera.DesafioTecnico.entity.Category;
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
public class CategoryInput {

    @Size(max = 15, message = "Name exceeds the maximum number of 15 characters")
    private String name;
    private String keyword;

    public static Category toEntity(CategoryInput categoryInput) {
        return Category.builder()
                .name(categoryInput.getName())
                .keyword(categoryInput.getKeyword().toUpperCase())
                .build();
    }
}
