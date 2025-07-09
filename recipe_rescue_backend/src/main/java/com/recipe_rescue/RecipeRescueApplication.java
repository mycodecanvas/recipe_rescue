package com.recipe_rescue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.recipe_rescue.persistence.repository")
@EntityScan("com.recipe_rescue.persistence.entities")
public class RecipeRescueApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecipeRescueApplication.class, args);
	}
}
