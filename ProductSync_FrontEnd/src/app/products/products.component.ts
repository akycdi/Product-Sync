import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Products } from '../../util/interfaces/models';
import { Data } from '../../util/data';
import { Router } from '@angular/router';
import { ProductsService } from '../services/products.service';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [NgFor],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit {

  private data: Data = new Data;

  products: Products[] = [];

  constructor(private router: Router, private productsService: ProductsService) {}

  ngOnInit(): void {
    this.productsService.getAllProducts().subscribe({
      next: (response: any) => {
        this.products = response;
      }
    })
  }

  viewProduct(id: Number): void {
    this.router.navigateByUrl(`/products/${id}`);
  }

}
