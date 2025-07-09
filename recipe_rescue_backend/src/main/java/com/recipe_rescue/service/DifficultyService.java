package com.recipe_rescue.service;

import com.recipe_rescue.domain.model.DifficultyDto;
import com.recipe_rescue.persistence.entities.DifficultyEntity;
import com.recipe_rescue.persistence.repository.DifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DifficultyService {
    @Autowired
    private DifficultyRepository difficultyRepository;

    public List<DifficultyDto> getAllDifficulties() {
        List<DifficultyEntity> difficultyEntities = difficultyRepository.findAll();
        List<DifficultyDto> difficultyDto = difficultyEntities.stream().map(level -> buildDifficultyDto(level)).collect(Collectors.toList());
        return difficultyDto;
    }

    private DifficultyDto buildDifficultyDto(DifficultyEntity entity) {
        DifficultyDto difficultyDto = new DifficultyDto();
        difficultyDto.setId(entity.getId());
        difficultyDto.setLevel(entity.getLevel().getDisplayName());

        return difficultyDto;
    }
}
