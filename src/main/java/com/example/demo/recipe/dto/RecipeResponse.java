package com.example.demo.recipe.dto;

import com.example.demo.recipe.enteties.Recette;

public class RecipeResponse {
    private Integer id;
    private String nom;
    private String description;
    private String instructions;
    private int temps_preparation;
    private String note;
    private String image;
    private Integer categorie_id;  // Only the ID for category

    public RecipeResponse(Recette recette) {
        this.id = recette.getId();
        this.nom = recette.getNom();
        this.description = recette.getDescription();
        this.instructions = recette.getInstructions();
        this.temps_preparation = recette.getTemps_preparation();
        this.note = recette.getNote();
        this.image = recette.getImage();
        this.categorie_id = recette.getCategorie() != null ? recette.getCategorie().getId() : null;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public int getTemps_preparation() {
        return temps_preparation;
    }

    public void setTemps_preparation(int temps_preparation) {
        this.temps_preparation = temps_preparation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Integer categorie_id) {
        this.categorie_id = categorie_id;
    }
}
