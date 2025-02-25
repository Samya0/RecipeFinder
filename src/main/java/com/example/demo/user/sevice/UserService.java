package com.example.demo.user.sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.user.enteties.User;
import com.example.demo.user.repository.UserRepository;


@Service  // Indique que c'est un service Spring
public class UserService {

    @Autowired  // Injection du repository UserRepository
    private UserRepository userRepository;

    // Méthode pour obtenir tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Retourne la liste de tous les utilisateurs
    }

    // Méthode pour obtenir un utilisateur par son ID
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);  // Retourne l'utilisateur ou null si non trouvé
    }

    // Méthode pour ajouter un nouvel utilisateur
    public User addUser(User user) {
        return userRepository.save(user);  // Sauvegarde un nouvel utilisateur
    }

    // Méthode pour mettre à jour un utilisateur
    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;  // Retourne null si l'utilisateur n'existe pas
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);  // Supprime l'utilisateur par son ID
    }
}
