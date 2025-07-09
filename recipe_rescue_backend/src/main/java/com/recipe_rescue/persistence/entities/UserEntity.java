package com.recipe_rescue.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    @NotNull
    private String username;

    @Column(name="difficulty_id")
    private Integer difficultyId;

    @Column(name="serving_size_id")
    private Integer servingSizeId;

    @Column(name="prep_time_id")
    private Integer prepTimeId;

    @Column(name="cuisine_id")
    private Integer cuisineId;
}
