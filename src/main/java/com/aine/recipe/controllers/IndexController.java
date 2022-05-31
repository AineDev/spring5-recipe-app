package com.aine.recipe.controllers;

import com.aine.recipe.domain.Category;
import com.aine.recipe.domain.UnitOfMeasurement;
import com.aine.recipe.repositories.CategoryRepository;
import com.aine.recipe.repositories.RecipeRepository;
import com.aine.recipe.repositories.UnitOfMeasurementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasurementRepository unitOfMeasurementRepository;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasurementRepository unitOfMeasurementRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByCategoryName("French");
        Optional<UnitOfMeasurement> unitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurement("tbsp");

        System.out.println("Category ID is: " + categoryOptional.get().getId());
        System.out.println("Category ID is: " + unitOfMeasurement.get().getId());

        return "index";
    }

    @RequestMapping("/recipes")
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());

        return "recipes";
    }
}
