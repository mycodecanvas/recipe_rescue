package com.recipe_rescue.persistence.entities;

import com.recipe_rescue.domain.enums.Difficulty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="difficulty_level")
public class DifficultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name="level")
    private Difficulty level;
}
