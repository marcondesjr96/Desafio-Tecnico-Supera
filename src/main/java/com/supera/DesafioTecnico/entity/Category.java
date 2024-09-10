package com.supera.DesafioTecnico.entity;

import com.supera.DesafioTecnico.entity.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String keyword;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", orphanRemoval = true)
    private List<Product> product;

    @PrePersist
    public void onPrePersist() {
        this.setStatus(StatusEnum.ENABLED);
    }

}
