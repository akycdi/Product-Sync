import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { Products } from '../../util/interfaces/models';
import { Data } from '../../util/data';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [NgFor],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {

  private data: Data = new Data;

  products: Products[] = this.data.all_products;

}
