package com.recipe_rescue.persistence.entities;

import com.recipe_rescue.domain.enums.Cuisine;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="cuisine")
public class CuisineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    @NotNull
    private Cuisine name;
}
