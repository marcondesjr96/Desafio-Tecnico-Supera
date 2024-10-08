package com.supera.DesafioTecnico.repository;

import com.supera.DesafioTecnico.dto.filter.FilterFindProduct;
import com.supera.DesafioTecnico.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT p FROM Product p " +
            "JOIN p.category c " +
            "WHERE c.keyword = :keyword " +
            "ORDER BY CASE " +
            "    WHEN p.priority = 'HIGH' THEN 1 " +
            "    WHEN p.priority = 'MEDIUM' THEN 2 " +
            "    ELSE 3 " +
            "END")
    List<Product> findAllOrderedByPriorityAndCategoryKeyword(@Param("keyword") String keyword);


    @Query("SELECT p FROM Product p " +
            "JOIN p.category c " +
            "WHERE (:#{#filter.categoryKey} IS NULL OR LOWER(c.keyword) = LOWER(:#{#filter.categoryKey})) " +
            "AND (:#{#filter.minPrice} IS NULL OR p.price >= :#{#filter.minPrice}) " +
            "AND (:#{#filter.maxPrice} IS NULL OR p.price <= :#{#filter.maxPrice}) " +
            "AND (:#{#filter.name} IS NULL OR LOWER(p.name) LIKE CONCAT('%', LOWER(:#{#filter.name}), '%')) " +
            "ORDER BY CASE " +
            "    WHEN p.priority = 'HIGH' THEN 1 " +
            "    WHEN p.priority = 'MEDIUM' THEN 2 " +
            "    ELSE 3 " +
            "END")
    List<Product> findAllByFilter(@Param("filter") FilterFindProduct filterFindProduct);
}
