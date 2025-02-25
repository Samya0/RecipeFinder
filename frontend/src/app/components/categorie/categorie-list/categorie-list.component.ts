import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../../../services/categorie.service';
import { Categorie } from '../../../models/categorie';
import {NgForOf} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-categorie-list',
  templateUrl: './categorie-list.component.html',
  imports: [
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./categorie-list.component.css']
})
export class CategorieListComponent implements OnInit {
  categories: Categorie[] = [];  // Store all categories

  constructor(private categorieService: CategorieService) {}

  ngOnInit(): void {
    this.getCategories();  // Fetch categories when component initializes
  }

  getCategories(): void {
    this.categorieService.getCategories()
      .subscribe({
        next: (data) => this.categories = data,
        error: (err) => console.error('Error fetching categories', err)
      });
  }
}
