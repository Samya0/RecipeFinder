import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule],  // Import RouterModule for routing functionality
  templateUrl: './app.component.html',  // Reference to the HTML file
  styleUrls: ['./app.component.css']   // Reference to the CSS file
})
export class AppComponent {
  title = 'RecipeHeaven';
}
