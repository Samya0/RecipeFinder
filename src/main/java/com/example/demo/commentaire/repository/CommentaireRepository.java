package com.example.demo.commentaire.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.commentaire.enteties.Commentaire;
import java.util.List;;
import com.example.demo.recipe.enteties.Recette;

@Repository  // Indique que c'est un composant Spring pour l'accès aux données
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
    // Ici aussi, on peut définir des méthodes personnalisées si nécessaire
    // Par exemple, pour obtenir tous les commentaires d'une recette
    List<Commentaire> findByRecette(Recette recette);  // Trouver les commentaires d'une recette spécifique
}
