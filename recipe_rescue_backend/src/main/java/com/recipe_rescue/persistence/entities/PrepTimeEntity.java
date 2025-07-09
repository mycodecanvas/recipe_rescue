package com.recipe_rescue.persistence.entities;

import com.recipe_rescue.domain.enums.PrepTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="prep_time_level")
public class PrepTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PrepTime name;
}
