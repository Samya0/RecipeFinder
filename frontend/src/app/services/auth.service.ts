import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';  // Assurez-vous que cela correspond à votre API backend

  constructor(private http: HttpClient) {}

  // Login method to authenticate the user
  login(credentials: { username: string; password: string }): Observable<any> {
    return this.http.post<{ token: string }>(`${this.apiUrl}/login`, credentials, { withCredentials: true }).pipe(
      catchError(this.handleError)
    );
  }

  // Register method to create a new user
  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user, { withCredentials: true }).pipe(
      catchError(this.handleError)
    );
  }

  // Check if user is logged in based on token in localStorage
  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  // Get user role from localStorage
  getRole(): string | null {
    return localStorage.getItem('role');
  }

  // Logout by removing token and role from localStorage
  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('role');
  }

  // Error handling function
  private handleError(error: any): Observable<never> {
    let errorMessage = 'An error occurred!';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Client-side error: ${error.error.message}`;
    } else {
      errorMessage = `Server-side error: ${error.status} - ${error.message}`;
    }
    return throwError(errorMessage);
  }

  // Function to store the token in localStorage after successful login
  storeToken(token: string): void {
    localStorage.setItem('token', token);
    console.log('Token enregistré avec succès:', token); // Debug (afficher le token reçu)
  }
}
