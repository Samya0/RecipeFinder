package com.example.demo.ingredient.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.ingredient.enteties.Ingredient;

@Repository  // Marque cette interface comme un repository Spring Data
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    // Si besoin, ajouter des méthodes personnalisées comme par exemple :
    List<Ingredient> findByNom(String nom);
    List<Ingredient> findByRecettes_Id(Integer recetteId);

}
