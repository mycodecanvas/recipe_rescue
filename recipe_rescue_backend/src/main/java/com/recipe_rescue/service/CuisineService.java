package com.recipe_rescue.service;

import com.recipe_rescue.domain.model.CuisineDto;
import com.recipe_rescue.persistence.entities.CuisineEntity;
import com.recipe_rescue.persistence.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuisineService {
    @Autowired
    CuisineRepository cuisineRepository;

    public List<CuisineDto> getAllCuisines() {
        List<CuisineEntity> cuisineEntityList = cuisineRepository.findAll();
        List<CuisineDto> cuisineDtoList = cuisineEntityList.stream()
                .map(cuisineEntity -> buildCuisineDto(cuisineEntity))
                .collect(Collectors.toList());
        return cuisineDtoList;
    }

    private CuisineDto buildCuisineDto(CuisineEntity entity) {
        CuisineDto cuisineDto = new CuisineDto();
        cuisineDto.setId(entity.getId());
        cuisineDto.setName(entity.getName().getDisplayName());
        return cuisineDto;
    }
}
