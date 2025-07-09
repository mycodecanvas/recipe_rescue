package com.recipe_rescue.persistence.repository;

import com.recipe_rescue.persistence.entities.CuisineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<CuisineEntity, Long> { }
