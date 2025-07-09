package com.recipe_rescue.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Cuisine {
    ASIAN("Asian", 1),
    EUROPEAN("European", 2),
    LATIN("Latin American & Caribbean", 3),
    NORTH_AMERICAN("North American", 4),
    AFRICAN("African", 5);

    private final String displayName;
    private final int id;
}
