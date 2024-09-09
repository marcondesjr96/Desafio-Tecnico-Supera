package com.supera.DesafioTecnico.dto.filter;

import com.supera.DesafioTecnico.entity.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductStatusUpdateDTO {

    private UUID productId;
    private StatusEnum status;

}
