package com.example.demo.categorie.controller;

import com.example.demo.recipe.enteties.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.categorie.service.CategorieService;
import com.example.demo.categorie.enteties.Categorie;
import com.example.demo.recipe.service.RecetteService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;
    @Autowired
    private RecetteService recetteService;

    // Récupérer toutes les catégories
    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable Integer id) {
        return categorieService.getCategorieById(id);
    }

    @GetMapping("/{categoryId}/recipes")
    public ResponseEntity<List<Recette>> getRecettesByCategorie(@PathVariable Integer categoryId) {
        List<Recette> recettes = recetteService.getRecettesByCategory(categoryId); // Call the instance method
        return recettes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(recettes);
    }


    // Ajouter une catégorie
    @PostMapping
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return categorieService.addCategorie(categorie);
    }

    // Supprimer une catégorie
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Integer id) {
        categorieService.deleteCategorie(id);
    }
}
