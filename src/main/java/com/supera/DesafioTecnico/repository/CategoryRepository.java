package com.supera.DesafioTecnico.repository;

import com.supera.DesafioTecnico.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByKeyword(String categoryKey);
}
