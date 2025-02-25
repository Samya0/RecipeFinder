package com.example.demo.souscategorie.enteties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import com.example.demo.categorie.enteties.Categorie;

@Entity  // Marks the class as a JPA entity
public class SousCategorie {

    @Id  // Denotes the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates the ID value
    private Integer id;

    @Column(nullable = false)  // Ensures the 'nom' (name) field cannot be null
    private String nom;  // Name of the subcategory

    // Many-to-one relationship with Categorie. Each subcategory belongs to one category.
    @ManyToOne
    @JoinColumn(name = "categorie_id")  // Specifies the foreign key column that links to the Categorie entity
    private Categorie categorie;  // The category that this subcategory belongs to

    // Getter for the 'id' field
    public Integer getId() {
        return id;  // Returns the ID of the subcategory
    }

    // Setter for the 'id' field
    public void setId(Integer id) {
        this.id = id;  // Sets the ID of the subcategory
    }

    // Getter for the 'nom' field
    public String getNom() {
        return nom;  // Returns the name of the subcategory
    }

    // Setter for the 'nom' field
    public void setNom(String nom) {
        this.nom = nom;  // Sets the name of the subcategory
    }

    // Getter for the 'categorie' field (The category to which this subcategory belongs)
    public Categorie getCategorie() {
        return categorie;  // Returns the category of this subcategory
    }

    // Setter for the 'categorie' field
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;  // Sets the category of this subcategory
    }
}
