package com.aine.recipe.domain;

import javax.persistence.*;
import java.util.Random;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // associated recipe to these notes
    @OneToOne
    private Recipe recipe;
    // true if recipe has been cooked
    private boolean cooked;
    // number between 1 & 5, elaborate later
    @Enumerated(value = EnumType.STRING)
    private Rating rating;
    @Lob
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public boolean isCooked() {
        return cooked;
    }

    public void setCooked(boolean cooked) {
        this.cooked = cooked;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
