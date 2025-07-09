package com.recipe_rescue.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Difficulty {
    EASY("Easy", 1),
    MEDIUM("Medium", 2),
    HARD("Hard", 3);

    private final String displayName;
    private final int id;

    public static Difficulty[] getAllValues() {
        return Difficulty.values();
    }
}
