package com.example.demo.recipe.controller;

import com.example.demo.recipe.dto.RecipeResponse;
import com.example.demo.recipe.enteties.Recette;
import com.example.demo.recipe.service.RecetteService;
import com.example.demo.categorie.enteties.Categorie;
import com.example.demo.categorie.repository.CategorieRepository;  // Import the repository
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    private final RecetteService recetteService;
    private final CategorieRepository categorieRepository;  // Inject the CategorieRepository

    public RecetteController(RecetteService recetteService, CategorieRepository categorieRepository) {
        this.recetteService = recetteService;
        this.categorieRepository = categorieRepository;
    }

    // Endpoint to get all recipes (GET /api/recettes)
    @GetMapping
    public ResponseEntity<List<Recette>> getAllRecettes() {
        List<Recette> recettes = recetteService.getAllRecettes();
        return ResponseEntity.ok(recettes);
    }

    // Endpoint to get a recipe by its ID (GET /api/recettes/{id})
    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable Integer id) {
        Recette recette = recetteService.getRecetteById(id);
        if (recette != null) {
            RecipeResponse recipeResponse = new RecipeResponse(recette);  // Map Recette to RecipeResponse
            return ResponseEntity.ok(recipeResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Endpoint to add a new recipe with image (POST /api/recettes)
    @PostMapping
    public ResponseEntity<Recette> addRecetteWithImage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("nom") String nom,
            @RequestParam("description") String description,
            @RequestParam("instructions") String instructions,
            @RequestParam("temps_preparation") int tempsPreparation,
            @RequestParam("note") String note,
            @RequestParam("categorieId") Integer categorieId) {  // Use categorieId to fetch the category

        // Fetch the Categorie object from the repository using the categorieId
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Create a new Recette object with the data
        Recette recette = new Recette();
        recette.setNom(nom);
        recette.setDescription(description);
        recette.setInstructions(instructions);
        recette.setTempsPreparation(tempsPreparation);
        recette.setNote(note);
        recette.setCategorie(categorie);  // Set the category to the fetched Categorie object

        // Add recipe with image
        Recette newRecette = recetteService.addRecetteWithImage(recette, image);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRecette);
    }

    // Endpoint to update a recipe (PUT /api/recettes/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable Integer id, @RequestBody Recette recette) {
        Recette updatedRecette = recetteService.updateRecette(id, recette);
        if (updatedRecette != null) {
            return ResponseEntity.ok(updatedRecette);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Endpoint to delete a recipe (DELETE /api/recettes/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Integer id) {
        boolean deleted = recetteService.deleteRecette(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
