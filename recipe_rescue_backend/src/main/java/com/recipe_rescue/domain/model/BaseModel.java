package com.recipe_rescue.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseModel {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
