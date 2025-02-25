import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import { RecipeService } from '../../../services/recipe.service';
import { CategorieService } from '../../../services/categorie.service';
import { Recipe } from '../../../models/recipe.model';
import { Ingredient } from '../../../models/ingredients';

import { Categorie } from '../../../models/categorie';
import {NgForOf, NgIf} from '@angular/common';



@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-detail.component.html',
  imports: [
    RouterLink,
    NgForOf
  ],
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  recipe: Recipe | null = null;  // Initialize as null
  categorie: Categorie | null = null;
  ingredients: Ingredient[] = [];

  constructor(
    private route: ActivatedRoute,
    private recipeService: RecipeService,
    private categorieService: CategorieService
  ) {}
  getInstructionsList(): string[] {
    return this.recipe?.instructions ? this.recipe.instructions.split('\n').map(step => step.trim()) : [];
  }
  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.recipeService.getRecipeById(id).subscribe(recipe => {
      this.recipe = recipe;

      // Fetch category if the recipe has a valid category ID
      if (recipe.categorie_id !== undefined && recipe.categorie_id !== null) {
        console.log('Fetching category with ID:', recipe.categorie_id);
        this.categorieService.getCategorieById(recipe.categorie_id).subscribe(category => {
          console.log('Category received:', category);
          this.categorie = category;
        }, error => {
          console.error('Error fetching category:', error);
        });
      } else {
        console.warn('Recipe does not have a valid categorie_id');
      }

      // Fetch ingredients for the recipe
      if (this.recipe.id) {
        this.recipeService.getIngredientsByRecetteId(this.recipe.id).subscribe(data => {
          this.ingredients = data;
        });
      }
    });
  }


}
