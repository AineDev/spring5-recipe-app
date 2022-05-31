package com.aine.recipe.domain;

import com.aine.recipe.repositories.UnitOfMeasurementRepository;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ingredient;
    @ManyToOne
    private Recipe recipe;
    private double amount;

    @OneToOne//(fetch = FetchType.EAGER) // default value, just for demonstration purposes
    private UnitOfMeasurement unitOfMeasurement;

    public Ingredient() {
    }

    public Ingredient(String ingredient, Double amount, UnitOfMeasurement unitOfMeasurement, Recipe recipe){
        this.ingredient = ingredient;
        this.amount = amount;
        this.unitOfMeasurement = unitOfMeasurement;
        this.recipe = recipe;
    }

    public Ingredient(String ingredient, UnitOfMeasurement unitOfMeasurement, Recipe recipe){
        this.ingredient = ingredient;
        this.unitOfMeasurement = unitOfMeasurement;
        this.recipe = recipe;
    }
    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
