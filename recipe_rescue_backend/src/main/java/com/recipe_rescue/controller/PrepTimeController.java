package com.recipe_rescue.controller;

import com.recipe_rescue.domain.model.PrepTimeDto;
import com.recipe_rescue.service.PrepTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PrepTimeController {
    @Autowired
    PrepTimeService prepTimeService;

    @GetMapping("/prep-times")
    public ResponseEntity<List<PrepTimeDto>> getAllPrepTimes() {
        try {
            List<PrepTimeDto> prepTimeDtoList = prepTimeService.getAllPrepTimes();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(prepTimeDtoList);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of());
        }
    }
}
