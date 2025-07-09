package com.recipe_rescue.persistence.repository;

import com.recipe_rescue.persistence.entities.PrepTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepTimeRepository extends JpaRepository<PrepTimeEntity, Long> { }
