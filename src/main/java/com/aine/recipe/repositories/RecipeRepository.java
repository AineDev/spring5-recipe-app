package com.aine.recipe.repositories;

import com.aine.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findAll();
}
