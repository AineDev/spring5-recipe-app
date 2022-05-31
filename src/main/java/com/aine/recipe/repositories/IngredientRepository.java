package com.aine.recipe.repositories;

import com.aine.recipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Iterable<Ingredient> findAll();
}
