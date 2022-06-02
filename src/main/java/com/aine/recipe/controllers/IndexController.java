package com.aine.recipe.controllers;

import com.aine.recipe.domain.Category;
import com.aine.recipe.domain.UnitOfMeasurement;
import com.aine.recipe.repositories.CategoryRepository;
import com.aine.recipe.repositories.RecipeRepository;
import com.aine.recipe.repositories.UnitOfMeasurementRepository;
import com.aine.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/recipes")
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        return "recipes";
    }
}
