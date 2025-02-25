export interface Recipe {
  id?: number;
  nom: string;
  description: string;
  instructions: string;
  image:string;
  temps_preparation: number;
  note: number;
  categorie_id: number;
  user_id: number;
}
