package com.example.demo.commentaire.enteties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import com.example.demo.recipe.enteties.Recette;
import com.example.demo.user.enteties.User;
@Entity  // Marks the class as a JPA entity
public class Commentaire {

    @Id  // Denotes the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates the ID value
    private Integer id;

    @Column(nullable = false)  // Ensures the 'contenu' (content) field cannot be null
    private String contenu;  // Content of the comment

    // Many-to-one relationship with Utilisateur. Each comment is made by one user.
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")  // Specifies the foreign key column that links to the Utilisateur entity
    private User utilisateur;  // The user who made the comment

    // Many-to-one relationship with Recette. Each comment is associated with one recipe.
    @ManyToOne
    @JoinColumn(name = "recette_id")  // Specifies the foreign key column that links to the Recette entity
    private Recette recette;  // The recipe that the comment is associated with

    // Getter for the 'id' field
    public Integer getId() {
        return id;  // Returns the ID of the comment
    }

    // Setter for the 'id' field
    public void setId(Integer id) {
        this.id = id;  // Sets the ID of the comment
    }

    // Getter for the 'contenu' field
    public String getContenu() {
        return contenu;  // Returns the content of the comment
    }

    // Setter for the 'contenu' field
    public void setContenu(String contenu) {
        this.contenu = contenu;  // Sets the content of the comment
    }

    // Getter for the 'utilisateur' field (The user who made the comment)
    public User getUtilisateur() {
        return utilisateur;  // Returns the user who made the comment
    }

    // Setter for the 'utilisateur' field
    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;  // Sets the user who made the comment
    }

    // Getter for the 'recette' field (The recipe the comment is associated with)
    public Recette getRecette() {
        return recette;  // Returns the recipe associated with the comment
    }

    // Setter for the 'recette' field
    public void setRecette(Recette recette) {
        this.recette = recette;  // Sets the recipe associated with the comment
    }
}
