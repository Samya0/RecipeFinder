package com.example.demo.recipe.enteties;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;  // Ajout de l'import pour ManyToMany
import jakarta.persistence.Column;
import com.example.demo.categorie.enteties.Categorie;
import com.example.demo.user.enteties.User;
import com.example.demo.ingredient.enteties.Ingredient;  // Importation de la classe Ingredient

import java.util.List;  // Importation de la classe List

@Entity  // Marque la classe comme une entité JPA
public class Recette {

    @Id  // Marque l'attribut 'id' comme la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Génère automatiquement l'ID pour chaque nouvelle instance
    private Integer id;

    @Column(nullable = false)  // La colonne 'nom' ne peut pas être nulle
    private String nom;  // Nom de la recette

    private String description;  // Description de la recette

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;  // Instructions de préparation de la recette

    private Integer temps_preparation;  // Temps de préparation en minutes


    private String image;

    private String note;  // Note ou évaluation de la recette

    // Relation Many-to-One entre Recette et Categorie. Chaque recette appartient à une catégorie.
    @ManyToOne  // Définit une relation Many-to-One avec l'entité Categorie
    @JoinColumn(name = "categorie_id")
    @JsonIgnore// Spécifie la colonne de clé étrangère dans la table Recette qui fait référence à Categorie
    private Categorie categorie;  // La catégorie à laquelle appartient la recette

    // Relation Many-to-One avec User (utilisateur ayant créé la recette)
    @ManyToOne  // Relation Many-to-One avec l'entité User
    @JoinColumn(name = "user_id")  // Colonne de clé étrangère vers l'utilisateur
    @JsonIgnore
    private User user;  // L'utilisateur qui a créé cette recette

    // Ajout d'une relation Many-to-Many avec Ingredient. Une recette peut avoir plusieurs ingrédients, et un ingrédient peut être utilisé dans plusieurs recettes.
    @ManyToMany  // Définir une relation Many-to-Many avec Ingredient
    @JoinTable(
            name = "recette_ingredient",  // Nom de la table de jonction (peut être personnalisé)
            joinColumns = @JoinColumn(name = "recette_id"),  // Colonne de clé étrangère pour Recette
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")  // Colonne de clé étrangère pour Ingredient
    )
    @JsonIgnore
    private List<Ingredient> ingredients;  // Liste d'ingrédients utilisés dans cette recette

    // Méthode pour obtenir la valeur de 'id'
    public Integer getId() {
        return id;  // Retourne l'ID de la recette
    }

    // Méthode pour définir la valeur de 'id'
    public void setId(Integer id) {
        this.id = id;  // Définit l'ID de la recette
    }

    // Méthode pour obtenir la valeur de 'nom'
    public String getNom() {
        return nom;  // Retourne le nom de la recette
    }

    // Méthode pour définir la valeur de 'nom'
    public void setNom(String nom) {
        this.nom = nom;  // Définit le nom de la recette
    }

    // Méthode pour obtenir la valeur de 'description'
    public String getDescription() {
        return description;  // Retourne la description de la recette
    }

    // Méthode pour définir la valeur de 'description'
    public void setDescription(String description) {
        this.description = description;  // Définit la description de la recette
    }

    // Méthode pour obtenir la valeur de 'instructions'
    public String getInstructions() {
        return instructions;  // Retourne les instructions de préparation de la recette
    }

    // Méthode pour définir la valeur de 'instructions'
    public void setInstructions(String instructions) {
        this.instructions = instructions;  // Définit les instructions de préparation de la recette
    }

    // Méthode pour obtenir la valeur de 'temps_preparation'
    public Integer getTemps_preparation() {
        return temps_preparation;  // Retourne le temps de préparation de la recette
    }

    // Méthode pour définir la valeur de 'temps_preparation'
    public void setTempsPreparation(Integer temps_preparation) {
        this.temps_preparation = temps_preparation;  // Définit le temps de préparation de la recette
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Méthode pour obtenir la valeur de 'note'
    public String getNote() {
        return note;  // Retourne la note de la recette
    }

    // Méthode pour définir la valeur de 'note'
    public void setNote(String note) {
        this.note = note;  // Définit la note de la recette
    }

    // Méthode pour obtenir la valeur de 'categorie'
    public Categorie getCategorie() {
        return categorie;  // Retourne la catégorie de la recette
    }

    // Méthode pour définir la valeur de 'categorie'
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;  // Définit la catégorie de la recette
    }

    // Méthode pour obtenir la liste des ingrédients
    public List<Ingredient> getIngredients() {
        return ingredients;  // Retourne la liste des ingrédients de la recette
    }

    // Méthode pour définir la liste des ingrédients
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;  // Définit la liste des ingrédients de la recette
    }

    // Méthode pour obtenir la valeur de 'user'
    public User getUser() {
        return user;  // Retourne l'utilisateur qui a créé cette recette
    }

    // Méthode pour définir la valeur de 'user'
    public void setUser(User user) {
        this.user = user;  // Définit l'utilisateur qui a créé cette recette
    }
}
