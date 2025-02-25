package com.example.demo.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import com.example.demo.recipe.enteties.Recette;
import com.example.demo.recipe.repository.RecetteRepository;
import com.example.demo.firebase.FirebaseStorageService;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    // Method to get all recipes
    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    // Method to get a recipe by ID
    public Recette getRecetteById(Integer id) {
        return recetteRepository.findById(id).orElse(null);
    }

    public List<Recette> getRecettesByCategory(Integer categoryId) {
        return recetteRepository.findByCategorieId(categoryId);
    }

    // Method to add a new recipe with image
    private FirebaseStorageService firebaseStorageService;

    // Method to add a new recipe with image
    public Recette addRecetteWithImage(Recette recette, MultipartFile image) {
        try {
            // Upload the image to Firebase and get the image URL
            String imageUrl = firebaseStorageService.uploadFile(image.getBytes(), image.getOriginalFilename());

            recette.setImage(imageUrl);  // Store the image URL in the Recette object

            return recetteRepository.save(recette);  // Save recette with image URL
        } catch (IOException e) {
            throw new RuntimeException("Error while uploading the image", e);
        }
    }


    // Method to update an existing recipe
    public Recette updateRecette(Integer id, Recette recetteDetails) {
        Recette recette = recetteRepository.findById(id).orElse(null);
        if (recette != null) {
            recette.setNom(recetteDetails.getNom());
            recette.setDescription(recetteDetails.getDescription());
            recette.setInstructions(recetteDetails.getInstructions());
            recette.setTempsPreparation(recetteDetails.getTemps_preparation());
            recette.setImage(recetteDetails.getImage());
            recette.setNote(recetteDetails.getNote());
            recette.setCategorie(recetteDetails.getCategorie());
            return recetteRepository.save(recette);
        }
        return null;
    }

    // Method to delete a recipe
    public boolean deleteRecette(Integer id) {
        if (recetteRepository.existsById(id)) {
            recetteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
