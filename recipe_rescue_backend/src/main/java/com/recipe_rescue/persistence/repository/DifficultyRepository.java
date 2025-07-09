package com.recipe_rescue.persistence.repository;

import com.recipe_rescue.persistence.entities.DifficultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<DifficultyEntity, Long> { }
