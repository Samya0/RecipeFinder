package com.example.demo.souscategorie.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.souscategorie.enteties.SousCategorie;
import com.example.demo.souscategorie.service.SousCategorieService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/souscategories")
public class SousCategorieController {

    @Autowired
    private SousCategorieService sousCategorieService;

    // Récupérer toutes les sous-catégories
    @GetMapping
    public List<SousCategorie> getAllSousCategories() {
        return sousCategorieService.getAllSousCategories();
    }

    // Ajouter une sous-catégorie
    @PostMapping
    public SousCategorie addSousCategorie(@RequestBody SousCategorie sousCategorie) {
        return sousCategorieService.addSousCategorie(sousCategorie);
    }

    // Supprimer une sous-catégorie
    @DeleteMapping("/{id}")
    public void deleteSousCategorie(@PathVariable Integer id) {
        sousCategorieService.deleteSousCategorie(id);
    }
}
