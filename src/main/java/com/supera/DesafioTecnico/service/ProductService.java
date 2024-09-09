package com.supera.DesafioTecnico.service;

import com.supera.DesafioTecnico.dto.filter.ProductStatusUpdateDTO;
import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;

import java.util.List;

public interface ProductService {

    ProductOutput create(ProductInput productInput);
    List<ProductOutput> saveList (List<ProductInput> productInputs);
    List<ProductOutput> updateList (List<ProductStatusUpdateDTO> updates);

}
