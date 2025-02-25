package com.example.demo.ingredient.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.ingredient.enteties.Ingredient;
import com.example.demo.ingredient.service.IngredientService;
import com.example.demo.recipe.enteties.Recette;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    // Récupérer tous les ingrédients
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Integer id) {
        return ingredientService.getIngredientById(id); // La méthode dans le service qui renvoie l'ingrédient avec ses recettes
    }
    // Ajouter un ingrédient
    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }
    @GetMapping("/recette/{recetteId}")
    public List<Ingredient> getIngredientsByRecette(@PathVariable Integer recetteId) {
        return ingredientService.getIngredientsByRecetteId(recetteId);
    }

    @GetMapping("/{ingredientId}/recettes")
    public List<Recette> getRecipesByIngredientId(@PathVariable Integer ingredientId) {
        return ingredientService.getRecipesByIngredientId(ingredientId);
    }



    // Supprimer un ingrédient
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Integer id) {
        ingredientService.deleteIngredient(id);
    }
}
