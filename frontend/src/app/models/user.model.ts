export interface User {
  id?: number; // Optionnel : généré automatiquement
  name: string; // Nom obligatoire
  email: string; // Email obligatoire
  password: string; // Mot de passe obligatoire
  role?: string; // Optionnel : rôle de l'utilisateur ('USER' ou 'ADMIN')
}
