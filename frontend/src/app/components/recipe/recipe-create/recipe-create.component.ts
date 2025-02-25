import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RecipeService } from '../../../services/recipe.service';
import { Recipe } from '../../../models/recipe.model';

@Component({
  selector: 'app-recipe-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './recipe-create.component.html',
  styleUrls: ['./recipe-create.component.css']
})
export class RecipeCreateComponent implements OnInit {
  recipe: Recipe = {
    nom: '',
    description: '',
    instructions: '',
    temps_preparation: 0,
    note: 0,
    categorie_id: 1,  // This will be updated by user selection
    user_id: 1,
    image: ''
  };

  categories = [
    { id: 1, name: 'Marocaine - Plat principal' },
    { id: 2, name: 'Marocaine - Entrée' },
    { id: 3, name: 'Marocaine - Soupe' },
    { id: 4, name: 'Marocaine - Dessert' },
    { id: 5, name: 'Italienne - Dessert' },
    { id: 6, name: 'Italienne - Soupe' },
    { id: 7, name: 'Européenne - Dessert' },
    { id: 8, name: 'Européenne - Plat principal' },
    { id: 9, name: 'Espagnol - Plat principal' },
    { id: 10, name: 'Étudiant - Plat rapide' },
    { id: 11, name: 'Anémie - Salade' },
    { id: 12, name: ' Anémie - Plat principal' },
    { id: 13, name: 'Sportif - Plat protéiné' }
  ];

  selectedFile: File | null = null;

  constructor(private recipeService: RecipeService, private router: Router) {}

  ngOnInit() {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  async saveRecipe() {
    try {
      if (this.selectedFile) {
        const imageUrl = await this.recipeService.uploadImage(this.selectedFile);
        this.recipe.image = imageUrl;
      }

      this.recipeService.createRecipe(this.recipe, this.selectedFile!).subscribe(() => {
        this.router.navigate(['/recipes']);
      });
    } catch (error) {
      console.error('Error uploading image:', error);
    }
  }

}
