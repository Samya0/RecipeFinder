import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import { RecipeService } from '../../../services/recipe.service';
import { Recipe } from '../../../models/recipe.model';
import {NgForOf, NgIf, NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-recipe-category-list',
  templateUrl: './recipe-category-list.component.html',
  imports: [
    RouterLink,
    NgForOf,
    NgIf,
    NgOptimizedImage
  ],
  styleUrls: ['./recipe-category-list.component.css']
})
export class RecipeCategoryListComponent implements OnInit {
  categoryId!: number;
  recipes: Recipe[] = [];

  constructor(
    private route: ActivatedRoute,
    private recipeService: RecipeService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.categoryId = Number(params.get('id'));
      if (this.categoryId) {
        this.getRecipesByCategory();
      }
    });
  }
  getRecipesByCategory(): void {
    if (!this.categoryId) {
      console.error('Category ID is missing');
      return;
    }

    this.recipeService.getRecipesByCategory(this.categoryId).subscribe({
      next: (recipes: Recipe[]) => {
        this.recipes = recipes;
      },
      error: (err) => {
        console.error('Error fetching recipes:', err);
      }
    });
  }

}
