import { Component, OnInit } from '@angular/core';
import { IngredientService } from '../../../services/ingredient.service';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  imports: [
    RouterLink,
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent implements OnInit {
  ingredients: any[] = [];

  constructor(private ingredientService: IngredientService) {}

  ngOnInit(): void {
    this.ingredientService.getIngredients().subscribe(data => {
      this.ingredients = data;
    });
  }
}
