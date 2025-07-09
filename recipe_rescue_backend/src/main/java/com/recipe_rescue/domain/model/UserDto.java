package com.recipe_rescue.domain.model;

import lombok.Data;

@Data
public class UserDto extends BaseModel {
    private Long id;
    private String username;
    private Integer difficultyId;
    private Integer servingSizeId;
    private Integer prepTimeId;
    private Integer cuisineId;
}
