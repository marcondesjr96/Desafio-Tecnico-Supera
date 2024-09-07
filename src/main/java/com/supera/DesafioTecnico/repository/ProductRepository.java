package com.supera.DesafioTecnico.repository;

import com.supera.DesafioTecnico.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
