package com.recipe_rescue.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PrepTime {
    QUICK("Quick (Under 15 min)", 1),
    MODERATE("Moderate (15-30 min)", 2),
    LENGTHY("Lengthy (30–60 min)", 3),
    ADVANCED("Advanced/Time-Intensive (Over 1 hr)", 4);

    private final String displayName;
    private final int id;
}
