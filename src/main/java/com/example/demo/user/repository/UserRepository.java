package com.example.demo.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.user.enteties.User;
import java.util.Optional;

@Repository  // Indique que c'est un composant Spring pour l'accès aux données
public interface UserRepository extends JpaRepository<User, Integer> {
    // Nous pouvons définir des méthodes personnalisées si nécessaire
    // Par exemple, pour trouver un utilisateur par son nom
    Optional<User> findByName(String name);  // Trouver un utilisateur en fonction de son nom
    Optional<User> findByEmail(String email);
}
