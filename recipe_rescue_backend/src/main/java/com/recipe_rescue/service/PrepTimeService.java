package com.recipe_rescue.service;

import com.recipe_rescue.domain.model.PrepTimeDto;
import com.recipe_rescue.persistence.entities.PrepTimeEntity;
import com.recipe_rescue.persistence.repository.PrepTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrepTimeService {
    @Autowired
    PrepTimeRepository prepTimeRepository;

    public List<PrepTimeDto> getAllPrepTimes() {
        List<PrepTimeEntity> prepTimeEntityList = prepTimeRepository.findAll();
        List<PrepTimeDto> dtoList = prepTimeEntityList.stream().map(entity -> buildPrepTimeDto(entity)).collect(Collectors.toList());
        return dtoList;
    }

    private PrepTimeDto buildPrepTimeDto (PrepTimeEntity entity) {
        PrepTimeDto prepTimeDto = new PrepTimeDto();
        prepTimeDto.setId(entity.getId());
        prepTimeDto.setName(entity.getName().getDisplayName());
        return prepTimeDto;
    }
}
