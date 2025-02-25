import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-create',
  standalone: true,
  imports: [CommonModule, FormsModule], // Importation des modules nécessaires
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent {
  user: User = {
    name: '',
    email: '',
    password: '',
    role: 'USER' // Par défaut, les utilisateurs auront ce rôle
  };

  constructor(private userService: UserService, private router: Router) {}

  saveUser() {
    this.userService.createUser(this.user).subscribe(
      () => {
        // Redirige vers la liste des utilisateurs après l'inscription
        this.router.navigate(['/users']);
      },
      error => {
        console.error('Erreur lors de la création de l\'utilisateur :', error);
      }
    );
  }
}
