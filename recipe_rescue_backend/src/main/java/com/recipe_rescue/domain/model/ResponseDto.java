package com.recipe_rescue.domain.model;

import lombok.Data;

@Data
public class ResponseDto {
    private String statusCode;
    private String statusMsg;
}
