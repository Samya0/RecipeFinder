package com.example.demo.souscategorie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.souscategorie.repository.SousCategorieRepository;
import com.example.demo.souscategorie.enteties.SousCategorie;

@Service  // Indique que c'est un service Spring
public class SousCategorieService {

    @Autowired  // Injection du repository SousCategorieRepository
    private SousCategorieRepository sousCategorieRepository;

    // Méthode pour obtenir toutes les sous-catégories
    public List<SousCategorie> getAllSousCategories() {
        return sousCategorieRepository.findAll();  // Retourne la liste de toutes les sous-catégories
    }

    // Méthode pour obtenir une sous-catégorie par son ID
    public SousCategorie getSousCategorieById(Integer id) {
        return sousCategorieRepository.findById(id).orElse(null);  // Retourne la sous-catégorie ou null si non trouvée
    }

    // Méthode pour ajouter une nouvelle sous-catégorie
    public SousCategorie addSousCategorie(SousCategorie sousCategorie) {
        return sousCategorieRepository.save(sousCategorie);  // Sauvegarde une nouvelle sous-catégorie
    }

    // Méthode pour mettre à jour une sous-catégorie
    public SousCategorie updateSousCategorie(Integer id, SousCategorie sousCategorieDetails) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(id).orElse(null);
        if (sousCategorie != null) {
            sousCategorie.setNom(sousCategorieDetails.getNom());  // Mise à jour du nom
            sousCategorie.setCategorie(sousCategorieDetails.getCategorie());  // Mise à jour de la catégorie associée
            return sousCategorieRepository.save(sousCategorie);  // Sauvegarde les modifications
        }
        return null;  // Retourne null si la sous-catégorie n'existe pas
    }

    // Méthode pour supprimer une sous-catégorie
    public void deleteSousCategorie(Integer id) {
        sousCategorieRepository.deleteById(id);  // Supprime la sous-catégorie par son ID
    }
}
