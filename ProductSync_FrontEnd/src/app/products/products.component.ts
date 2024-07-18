import { Component } from '@angular/core';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {

  products: Products[] = [];

}

interface Products {
  id: Number
  name: String
  description: String
  price: Number
  quantity: Number
  category: Category
  createdDate: String
  soldDate: String
}

interface Category {
  id: Number
  name: String
}
