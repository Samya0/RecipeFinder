package com.example.demo.categorie.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import java.util.List;
import com.example.demo.recipe.enteties.Recette;  // Correct import


@Entity  // Marks the class as a JPA entity
public class Categorie {

    @Id  // Denotes the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates the ID value
    private Integer id;

    @Column(nullable = false)  // Ensures the 'nom' (name) field cannot be null
    private String nom;  // Name of the category ex(morrocan, italien, etc)

    private String type;  // Type of the category (e.g., anemia, dessert, lunch etc.)

    // One-to-many relationship with Recette. Each category can have multiple recipes.
    @OneToMany(mappedBy = "categorie")  // Defines a one-to-many relationship with Recette
    private List<Recette> recettes;  // List of recipes that belong to this category

    // Getter for the 'id' field
    public Integer getId() {
        return id;  // Returns the ID of the category
    }

    // Setter for the 'id' field
    public void setId(Integer id) {
        this.id = id;  // Sets the ID of the category
    }

    // Getter for the 'nom' field
    public String getNom() {
        return nom;  // Returns the name of the category
    }

    // Setter for the 'nom' field
    public void setNom(String nom) {
        this.nom = nom;  // Sets the name of the category
    }

    // Getter for the 'type' field
    public String getType() {
        return type;  // Returns the type of the category
    }

    // Setter for the 'type' field
    public void setType(String type) {
        this.type = type;  // Sets the type of the category
    }

    // Getter for the 'recettes' field (List of recipes in this category)
    public List<Recette> getRecettes() {
        return recettes;  // Returns the list of recipes in this category
    }

    // Setter for the 'recettes' field
    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;  // Sets the list of recipes in this category
    }
}
