package com.recipe_rescue.controller;

import com.recipe_rescue.domain.model.CuisineDto;
import com.recipe_rescue.domain.model.ResponseDto;
import com.recipe_rescue.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CuisineController {
    @Autowired
    CuisineService cuisineService;

    @GetMapping("/cuisines")
    public ResponseEntity<List<CuisineDto>> getAllCuisines() {
        try {
            List<CuisineDto> cuisineDtoList = cuisineService.getAllCuisines();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(cuisineDtoList);
        } catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of());
        }
    }
}
