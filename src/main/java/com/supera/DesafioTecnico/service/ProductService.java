package com.supera.DesafioTecnico.service;

import com.supera.DesafioTecnico.dto.filter.FilterFindProduct;
import com.supera.DesafioTecnico.dto.input.ProductPriorityUpdateDTO;
import com.supera.DesafioTecnico.dto.input.ProductStatusUpdateDTO;
import com.supera.DesafioTecnico.dto.input.ProductInput;
import com.supera.DesafioTecnico.dto.output.ProductOutput;

import java.util.List;

public interface ProductService {

    ProductOutput create(ProductInput productInput);

    List<ProductOutput> saveList(List<ProductInput> productInputs);

    List<ProductOutput> updateStatusList(List<ProductStatusUpdateDTO> updates);

    List<ProductOutput> findAllOrderedByPriority(String categoryKey);

    List<ProductOutput> updatePriorityList(List<ProductPriorityUpdateDTO> updates);

    List<ProductOutput> findByFilterProduct(FilterFindProduct filterFindProduct);

}
