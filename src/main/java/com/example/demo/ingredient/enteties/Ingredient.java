package com.example.demo.ingredient.enteties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import java.util.List;
import com.example.demo.recipe.enteties.Recette;

@Entity  // Marks the class as a JPA entity
public class Ingredient {

    @Id  // Denotes the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates the ID value
    private Integer id;

    @Column(nullable = false)  // Ensures that the 'nom' (name) field cannot be null
    private String nom;  // Name of the ingredient

    @Column(nullable = false)  // Ensures that the 'quantite' (quantity) field cannot be null
    private String quantite;  // Quantity of the ingredient (e.g., "2 cups", "500g")

    // Many-to-many relationship with Recette. An ingredient can be used in many recipes, and a recipe can have many ingredients.
    @ManyToMany(mappedBy = "ingredients")  // Defines a many-to-many relationship with Recette
    private List<Recette> recettes;  // List of recipes that use this ingredient

    // Getter for the 'id' field
    public Integer getId() {
        return id;  // Returns the ID of the ingredient
    }

    // Setter for the 'id' field
    public void setId(Integer id) {
        this.id = id;  // Sets the ID of the ingredient
    }

    // Getter for the 'nom' field
    public String getNom() {
        return nom;  // Returns the name of the ingredient
    }

    // Setter for the 'nom' field
    public void setNom(String nom) {
        this.nom = nom;  // Sets the name of the ingredient
    }

    // Getter for the 'quantite' field
    public String getQuantite() {
        return quantite;  // Returns the quantity of the ingredient
    }

    // Setter for the 'quantite' field
    public void setQuantite(String quantite) {
        this.quantite = quantite;  // Sets the quantity of the ingredient
    }

    // Getter for the 'recettes' field (List of recipes using this ingredient)
    public List<Recette> getRecettes() {
        return recettes;  // Returns the list of recipes that use this ingredient
    }

    // Setter for the 'recettes' field
    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;  // Sets the list of recipes that use this ingredient
    }
}
