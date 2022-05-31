package com.aine.recipe.bootstrap;

import com.aine.recipe.domain.*;
import com.aine.recipe.repositories.CategoryRepository;
import com.aine.recipe.repositories.IngredientRepository;
import com.aine.recipe.repositories.RecipeRepository;
import com.aine.recipe.repositories.UnitOfMeasurementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasurementRepository unitOfMeasurementRepository;

    public BootStrapData(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasurementRepository unitOfMeasurementRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrapping data for recipes");
        // Getting Categories & Unit of Measurements
        Optional<Category> frenchCategoryO = categoryRepository.findByCategoryName("French");
        Optional<Category> italianCategoryO = categoryRepository.findByCategoryName("Italian");
        Optional<UnitOfMeasurement> wholeUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("whole");
        Optional<UnitOfMeasurement> tbspUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("tbsp");
        Optional<UnitOfMeasurement> tspUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("tsp");
        Optional<UnitOfMeasurement> pinchUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("pinch");
        Optional<UnitOfMeasurement> cloveUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("clove");
        Optional<UnitOfMeasurement> cupUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("cup");
        Optional<UnitOfMeasurement> slicesUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("slices");
        Optional<UnitOfMeasurement> gramsUOMO = unitOfMeasurementRepository.findByUnitOfMeasurement("grams");
        if ((!frenchCategoryO.isPresent()) | (!italianCategoryO.isPresent())){
            throw new RuntimeException("Category not found");
        }
        if ((!wholeUOMO.isPresent()) | (!tbspUOMO.isPresent()) | (!tspUOMO.isPresent()) |(!pinchUOMO.isPresent())
                |(!cloveUOMO.isPresent()) |(!cupUOMO.isPresent()) |(!slicesUOMO.isPresent()) |(!gramsUOMO.isPresent())){
            throw new RuntimeException("Category not found");
        }

        Category frenchCategory = frenchCategoryO.get();
        Category italianCategory = italianCategoryO.get();
        UnitOfMeasurement wholeUOM = wholeUOMO.get();
        UnitOfMeasurement tbspUOM = tbspUOMO.get();
        UnitOfMeasurement tspUOM = tspUOMO.get();
        UnitOfMeasurement pinchUOM = pinchUOMO.get();
        UnitOfMeasurement cloveUOM = cloveUOMO.get();
        UnitOfMeasurement cupUOM = cupUOMO.get();
        UnitOfMeasurement slicesUOM = slicesUOMO.get();
        UnitOfMeasurement gramsUOM = gramsUOMO.get();



//        FRENCH ONION SOUP
        Recipe FrenchOnionSoup = new Recipe();
        FrenchOnionSoup.setTitle("French Onion Soup");
        FrenchOnionSoup.setDescription("Warm, cozy, and flavorful, this French onion soup is prepared with beef stock and caramelized onions. Top with croutons covered in melty Gruyere and Parmesan cheese.");
        FrenchOnionSoup.setInstructions("Caramelize the onions:\n" +
                "In a 5 to 6 quart thick-bottomed pot, heat 3 tablespoons of olive oil on medium heat. Add the onions and toss to coat with the olive oil.\n" +
                "\n" +
                "Cook the onions, stirring often, until they have softened, about 15 to 20 minutes.\n" +
                "\n" +
                "Increase the heat to medium high. Add the remaining tablespoon of olive oil and the butter and cook, stirring often, until the onions start to brown, about 15 more minutes.Sprinkle with sugar (to help with the caramelization) and 1 teaspoon of salt. Continue to cook until the onions are well browned, about 10 to 15 more minutes.Add the minced garlic and cook for a minute more.\n" +
                "\n" +
                "Deglaze the pot with vermouth or wine:\n" +
                "Add the wine or vermouth to the pot and scrape up the browned bits on the bottom and sides of the pot, deglazing the pot as you go.Add the stock, bay leaves, and thyme:\n" +
                "Add the stock, bay leaves, and thyme. Bring to a simmer, cover the pot and lower the heat to maintain a low simmer. Cook for about 30 minutes.\n" +
                "\nSeason to taste with more salt and add freshly ground black pepper. Discard the bay leaves. Add brandy if using.\n" +
                "\n" +
                "Toast the French bread slices:\n" +
                "While the soup is simmering, line a sheet pan with parchment paper or foil and preheat the oven to 450°F with a rack in the upper third of the oven.\n" +
                "\n" +
                "Brush both sides of the French bread or baguette slices lightly with olive oil (you'll end up using about a tablespoon and a half of olive oil for this).\n" +
                "\n" +
                "Put in the oven and toast until lightly browned, about 5 to 7 minutes. Remove from oven.Turn the toasts over and sprinkle with the grated Gruyere cheese and Parmesan. Return to oven when it's close to serving time and bake until the cheese is bubbly and lightly browned.\n" +
                "\n" +
                "Serve:\n" +
                "To serve, ladle soup into a bowl and transfer one cheesy toast onto the top of each bowl of soup.\n" +
                "\n" +
                "Alternatively, you can use individual oven-proof bowls or one large casserole dish. Ladle the soup into the bowls or casserole dish. Cover with the toast and sprinkle with cheese. Put into the broiler for 10 minutes at 350° F, or until the cheese bubbles and is slightly browned.");
        FrenchOnionSoup.setPrepTime(10);
        FrenchOnionSoup.setCookTime(70);
        FrenchOnionSoup.setServings(5);
        FrenchOnionSoup.setSource("https://www.simplyrecipes.com/recipes/french_onion_soup/");
        FrenchOnionSoup.setCooked(Boolean.TRUE);
        FrenchOnionSoup.setNotes(new Notes());
        FrenchOnionSoup.getCategories().add(frenchCategory);

        FrenchOnionSoup.getIngredients().add(new Ingredient("Red or Yellow Onions", 6.0, wholeUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient("Extra Virgin Olive Oil", 4.0, tbspUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Butter", 2.0, tbspUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Sugar", 1.0, tspUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Salt", pinchUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Garlic, minced", 2.0, cloveUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Chicken or Vegetarian Stock (traditionally made with beef stock)", 8.0, cupUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Dry Vermouth or Dry White Wine", 0.5, cupUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Bay Leaves", 2.0, wholeUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Fresh Thyme Leaves (or 1/2 tsp dried thyme)", 1.0, tbspUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Freshly Ground Black Pepper", 0.5, tspUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Brandy (optional)", 2.0, tbspUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "French Bread or Baguette (1 inch thick)", 8.0, slicesUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Grated Gruyere", 1.5, cupUOM, FrenchOnionSoup));
        FrenchOnionSoup.getIngredients().add(new Ingredient( "Parmesan",  pinchUOM, FrenchOnionSoup));

        recipeRepository.save(FrenchOnionSoup);

//      Spaghetti Carbonara
        Recipe spaghettiCarbonara = new Recipe();
        spaghettiCarbonara.setTitle("Spaghetti Carbonara");
        spaghettiCarbonara.setDescription("This dish is a deli egg-bacon-and-cheese-on-a-roll that has been pasta-fied, fancified, fetishized and turned into an Italian tradition Remember: the main goal is creaminess.");
        spaghettiCarbonara.setInstructions("Place a large pot of lightly salted water (no more than 1 tablespoon salt) over high heat, and bring to a boil. Fill a large bowl with hot water for serving, and set aside.\n" +
                "In a mixing bowl, whisk together the eggs, yolks and pecorino and Parmesan. Season with a pinch of salt and generous black pepper.\n" +
                "Set the water to boil. Meanwhile, heat oil in a large skillet over medium heat, add the pork, and sauté until the fat just renders, on the edge of crispness but not hard. Remove from heat and set aside.\n" +
                "Add pasta to the water and boil until a bit firmer than al dente. Just before pasta is ready, reheat guanciale in skillet, if needed. Reserve 1 cup of pasta water, then drain pasta and add to the skillet over low heat. Stir for a minute or so.\n" +
                "Empty serving bowl of hot water. Dry it and add hot pasta mixture. Stir in cheese mixture, adding some reserved pasta water if needed for creaminess. Serve immediately, dressing it with a bit of additional grated pecorino and pepper.");
        spaghettiCarbonara.setPrepTime(5);
        spaghettiCarbonara.setCookTime(25);
        spaghettiCarbonara.setServings(4);
        spaghettiCarbonara.setSource("https://cooking.nytimes.com/recipes/12965-spaghetti-carbonara");
        spaghettiCarbonara.setCooked(Boolean.FALSE);
        spaghettiCarbonara.setNotes(new Notes());
        spaghettiCarbonara.getCategories().add(italianCategory);

        spaghettiCarbonara.getIngredients().add(new Ingredient("Salt", pinchUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("Eggs", 2.0, wholeUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("Grated Parmesan", 30.0, gramsUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("Grated Pecorino Romano, additional for serving", 30.0, gramsUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("Freshly Cracked Black Pepper", pinchUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("Extra Virgin Olive Oil", 1.0, tbspUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("Pancetta or Bacon, sliced into pieces about 1/4 in by 1/3 inch square", 100.0, gramsUOM, spaghettiCarbonara));
        spaghettiCarbonara.getIngredients().add(new Ingredient("spaghetti", 340.0, gramsUOM, spaghettiCarbonara));

        recipeRepository.save(spaghettiCarbonara);
        System.out.println("Added Carbonara, Recipe Count: " + recipeRepository.count());
    }
}
