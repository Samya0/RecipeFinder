import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe } from '../models/recipe.model';
import {Ingredient} from '../models/ingredients';
import { Storage, ref, uploadBytes, getDownloadURL } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private apiUrl = 'http://localhost:8080/api/recettes';
  private categoriesApiUrl = 'http://localhost:8080/api/categories';
  private ingredientsApiUrl = 'http://localhost:8080/api';


  constructor(private http: HttpClient, private storage: Storage) {}

  // ✅ Fetch all recipes
  getRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.apiUrl);
  }

  // ✅ Fetch a single recipe by ID
  getRecipeById(id: number): Observable<Recipe> {
    return this.http.get<Recipe>(`${this.apiUrl}/${id}`);
  }

  // ✅ Upload an image and return its URL
  uploadImage(file: File): Promise<string> {
    const filePath = `recipes/${file.name}`;
    const storageRef = ref(this.storage, filePath);
    return uploadBytes(storageRef, file).then(() =>
      getDownloadURL(storageRef)
    );
  }

  createRecipe(recipe: Recipe, imageFile: File): Observable<Recipe> {
    const formData = new FormData();
    formData.append('image', imageFile);
    formData.append('nom', recipe.nom);
    formData.append('description', recipe.description);
    formData.append('instructions', recipe.instructions);
    formData.append('temps_preparation', recipe. temps_preparation.toString());
    formData.append('note', recipe.note.toString());
    formData.append('categorieId', recipe.categorie_id.toString());

    return this.http.post<Recipe>(this.apiUrl, formData);
  }


  getRecipesByCategory(categoryId: number): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(`${this.categoriesApiUrl}/${categoryId}/recipes`);
  }

  getIngredientsByRecetteId(recetteId: number): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(`${this.ingredientsApiUrl}/ingredients/recette/${recetteId}`);
  }



}
