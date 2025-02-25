import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import { IngredientService } from '../../../services/ingredient.service';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-ingredient-detail',
  templateUrl: './ingredient-detail.component.html',
  imports: [
    RouterLink,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./ingredient-detail.component.css']
})
export class IngredientDetailComponent implements OnInit {
  ingredient: any;
  recipes: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private ingredientService: IngredientService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      // Fetch ingredient details
      this.ingredientService.getIngredientById(id).subscribe(data => {
        this.ingredient = data;
        // After fetching ingredient, fetch recipes that use this ingredient
        this.ingredientService.getRecipesByIngredientId(id).subscribe(recipeData => {
          this.recipes = recipeData;
        });
      });
    }
  }
}
