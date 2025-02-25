package com.example.demo.commentaire.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.commentaire.repository.CommentaireRepository;
import com.example.demo.commentaire.enteties.Commentaire;
import com.example.demo.recipe.enteties.Recette;

@Service  // Indique que c'est un composant Spring de type Service
public class CommentaireService {

    @Autowired  // Injection du repository CommentaireRepository
    private CommentaireRepository commentaireRepository;

    // Méthode pour obtenir tous les commentaires d'une recette
    public List<Commentaire> getCommentairesByRecette(Recette recette) {
        return commentaireRepository.findByRecette(recette);  // Recherche les commentaires d'une recette spécifique
    }

    // Méthode pour ajouter un commentaire
    public Commentaire addCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);  // Sauvegarde un nouveau commentaire
    }

    // Méthode pour supprimer un commentaire
    public void deleteCommentaire(Integer id) {
        commentaireRepository.deleteById(id);  // Supprime le commentaire par son ID
    }
}
