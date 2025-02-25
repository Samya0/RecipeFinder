import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {
  private apiUrl = 'http://localhost:8080/api/ingredients';

  constructor(private http: HttpClient) {}

  getIngredients(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getIngredientById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }



  // Fetch recipes that contain a specific ingredient
  getRecipesByIngredientId(ingredientId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/${ingredientId}/recettes`);
  }
}
