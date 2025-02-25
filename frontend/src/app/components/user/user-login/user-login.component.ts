import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule],
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';
  loading: boolean = false;

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    if (!this.username || !this.password) {
      this.errorMessage = 'Both fields are required!';
      return;
    }

    this.loading = true;
    this.authService.login({ username: this.username, password: this.password }).subscribe(
      response => {
        // Utiliser storeToken pour stocker le token et le rôle
        const token = response.token;
        const role = response.role; // Assurez-vous que le backend renvoie également le rôle
        this.authService.storeToken(token);  // Enregistrement du token
        localStorage.setItem('role', role);  // Enregistrement du rôle
        this.router.navigate(['/recipes']); // Redirection après connexion
        this.loading = false;
      },
      error => {
        this.errorMessage = 'Invalid username or password!'; // Message pour une erreur de connexion
        this.loading = false;
      }
    );
  }
}
