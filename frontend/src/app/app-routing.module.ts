import { Routes } from '@angular/router';
import { RecipeListComponent } from './components/recipe/recipe-list/recipe-list.component';
import { RecipeDetailsComponent } from './components/recipe/recipe-detail/recipe-detail.component';
import { RecipeCreateComponent } from './components/recipe/recipe-create/recipe-create.component';

import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserCreateComponent } from './components/user/user-create/user-create.component';
import { UserLoginComponent } from './components/user/user-login/user-login.component';

import { CategorieListComponent } from './components/categorie/categorie-list/categorie-list.component';
import {RecipeCategoryListComponent} from './components/categorie/recipe-category-list/recipe-category-list.component';

import {IngredientListComponent} from './components/ingredient/ingredient-list/ingredient-list.component';
import {IngredientDetailComponent} from './components/ingredient/ingredient-detail/ingredient-detail.component'

export const routes: Routes = [
  { path: 'recipes', component: RecipeListComponent },
  { path: 'recipes/add', component: RecipeCreateComponent },
  { path: 'recipes/:id', component: RecipeDetailsComponent },

  { path: 'users', component: UserListComponent },
  { path: 'users/add', component: UserCreateComponent },
  { path: 'login', component: UserLoginComponent },

  { path: 'categories', component: CategorieListComponent },
  { path: 'categories/:id/recipes', component: RecipeCategoryListComponent },

  { path: 'ingredients', component: IngredientListComponent },
  { path: 'ingredient/:id', component: IngredientDetailComponent },


  { path: '', redirectTo: '/recipes', pathMatch: 'full' }
];
