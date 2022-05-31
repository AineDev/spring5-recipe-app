package com.aine.recipe.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String description;
    @Lob
    private String instructions;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private Boolean cooked;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @Lob
    private Byte[] image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getCooked() {
        return cooked;
    }

    public void setCooked(Boolean cooked) {
        this.cooked = cooked;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", servings=" + servings +
                ", source='" + source + '\'' +
                ", cooked=" + cooked +
                ", notes=" + notes +
                ", image=" + Arrays.toString(image) +
                ", ingredients=" + ingredients +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id.equals(recipe.id) && Objects.equals(title, recipe.title) && Objects.equals(description, recipe.description) && Objects.equals(instructions, recipe.instructions) && Objects.equals(prepTime, recipe.prepTime) && Objects.equals(cookTime, recipe.cookTime) && Objects.equals(servings, recipe.servings) && Objects.equals(source, recipe.source) && Objects.equals(cooked, recipe.cooked) && Objects.equals(notes, recipe.notes) && Arrays.equals(image, recipe.image) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(categories, recipe.categories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, description, instructions, prepTime, cookTime, servings, source, cooked, notes, ingredients, categories);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
