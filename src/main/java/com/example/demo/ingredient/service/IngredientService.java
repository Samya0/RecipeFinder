package com.example.demo.ingredient.service;

import com.example.demo.recipe.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.ingredient.enteties.Ingredient;
import com.example.demo.ingredient.repository.IngredientRepository;
import com.example.demo.recipe.enteties.Recette;


@Service  // Marks this class as a Spring service
public class IngredientService {

    @Autowired  // Injection of the IngredientRepository
    private IngredientRepository ingredientRepository;
    private RecetteRepository recetteRepository;

    // Constructor injection (optional, since @Autowired on the field can also work)
    public IngredientService(IngredientRepository ingredientRepository, RecetteRepository recetteRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recetteRepository = recetteRepository;
    }


    // Method to get all ingredients
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();  // Returns the list of all ingredients
    }

    // Method to get an ingredient by its ID
    public Ingredient getIngredientById(Integer id) {
        return ingredientRepository.findById(id).orElse(null);  // Returns the ingredient or null if not found
    }

    // Method to add a new ingredient
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);  // Saves an ingredient
    }

    // Method to update an ingredient
    public Ingredient updateIngredient(Integer id, Ingredient ingredientDetails) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        if (ingredient != null) {
            ingredient.setNom(ingredientDetails.getNom());
            ingredient.setQuantite(ingredientDetails.getQuantite());
            return ingredientRepository.save(ingredient);
        }
        return null;  // Returns null if the ingredient does not exist
    }

    // Method to get ingredients by recipe ID
    public List<Ingredient> getIngredientsByRecetteId(Integer recetteId) {
        return ingredientRepository.findByRecettes_Id(recetteId);
    }

    public List<Recette> getRecipesByIngredientId(Integer ingredientId) {
        return recetteRepository.findByIngredientsId(ingredientId); // Assuming you have a relationship between recipes and ingredients
    }


    // Method to delete an ingredient
    public void deleteIngredient(Integer id) {
        ingredientRepository.deleteById(id);  // Deletes the ingredient by its ID
    }
}
