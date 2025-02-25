package com.example.demo.commentaire.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.commentaire.service.CommentaireService;
import com.example.demo.commentaire.enteties.Commentaire;
import com.example.demo.recipe.enteties.Recette;
import com.example.demo.recipe.service.RecetteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private RecetteService recetteService;  // Inject RecetteService to get Recette details

    // Récupérer tous les commentaires d'une recette
    @GetMapping("/recette/{id}")
    public List<Commentaire> getCommentairesByRecette(@PathVariable Integer id) {
        // Retrieve the Recette from the database using the service
        Recette recette = recetteService.getRecetteById(id);

        return commentaireService.getCommentairesByRecette(recette); // Fetch comments for this recette

    }

    // Ajouter un commentaire
    @PostMapping
    public Commentaire addCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireService.addCommentaire(commentaire);
    }

    // Supprimer un commentaire
    @DeleteMapping("/{id}")
    public void deleteCommentaire(@PathVariable Integer id) {
        commentaireService.deleteCommentaire(id);
    }
}
