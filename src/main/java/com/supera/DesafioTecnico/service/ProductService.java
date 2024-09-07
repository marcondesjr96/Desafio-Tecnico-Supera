package com.supera.DesafioTecnico.service;

import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;

public interface ProductService {

    ProductOutput create(ProductInput productInput);
}
