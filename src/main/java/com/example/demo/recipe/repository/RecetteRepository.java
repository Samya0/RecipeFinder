package com.example.demo.recipe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.recipe.enteties.Recette;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Integer> {
    List<Recette> findByCategorieId(Integer categorieId);
    List<Recette> findByIngredientsId(Integer ingredientsId);
}
