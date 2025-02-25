package com.example.demo.categorie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.categorie.enteties.Categorie;

@Repository  // Marks this interface as a Spring Data repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    // Custom query methods can be added here if needed
}
