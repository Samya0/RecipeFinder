package com.example.demo.categorie.service;

import com.example.demo.recipe.enteties.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.categorie.repository.CategorieRepository;
import com.example.demo.categorie.enteties.Categorie;
import com.example.demo.recipe.repository.RecetteRepository;

@Service  // Indique que c'est un service Spring
public class CategorieService {

    @Autowired  // Injection du repository CategorieRepository
    private CategorieRepository categorieRepository;

    // Méthode pour obtenir toutes les catégories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();  // Retourne la liste de toutes les catégories
    }

    // Méthode pour obtenir une catégorie par son ID
    public Categorie getCategorieById(Integer id) {
        return categorieRepository.findById(id).orElse(null);  // Retourne la catégorie ou null si non trouvée
    }

    // Méthode pour ajouter une nouvelle catégorie
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);  // Sauvegarde une nouvelle catégorie
    }

    // Méthode pour mettre à jour une catégorie
    public Categorie updateCategorie(Integer id, Categorie categorieDetails) {
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie != null) {
            categorie.setNom(categorieDetails.getNom());  // Mise à jour du nom
            return categorieRepository.save(categorie);  // Sauvegarde les modifications
        }
        return null;  // Retourne null si la catégorie n'existe pas
    }

    // Méthode pour supprimer une catégorie
    public void deleteCategorie(Integer id) {
        categorieRepository.deleteById(id);  // Supprime la catégorie par son ID
    }
}
