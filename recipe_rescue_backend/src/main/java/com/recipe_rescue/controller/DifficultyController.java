package com.recipe_rescue.controller;

import com.recipe_rescue.domain.model.DifficultyDto;
import com.recipe_rescue.domain.model.UserDto;
import com.recipe_rescue.service.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class DifficultyController {
    @Autowired
    private DifficultyService difficultyService;

    @GetMapping("/difficulties")
    public ResponseEntity<List<DifficultyDto>> getAllDifficultyLevels() {
        List<DifficultyDto> result = difficultyService.getAllDifficulties();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}
