import { Component, OnInit } from '@angular/core';
import { Category } from '../../util/interfaces/models';
import { Data } from '../../util/data';
import { NgFor } from '@angular/common';
import { ProductsService } from '../services/products.service';

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [NgFor],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent implements OnInit {

  private data: Data = new Data;
  categories: Category[] = [];

  constructor(private productsService: ProductsService) {}

  ngOnInit(): void {
    this.productsService.getAllProducts().subscribe({
      next: (response: any) => {
        this.categories = response;
      }
    })
  }

}
