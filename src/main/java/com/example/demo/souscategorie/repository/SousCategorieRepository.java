package com.example.demo.souscategorie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.souscategorie.enteties.SousCategorie;

@Repository  // Marks this interface as a Spring Data repository
public interface SousCategorieRepository extends JpaRepository<SousCategorie, Integer> {
    // Custom query methods can be added here if needed
}
