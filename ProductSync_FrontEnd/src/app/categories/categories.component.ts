import { Component } from '@angular/core';
import { Category } from '../../util/interfaces/models';
import { Data } from '../../util/data';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [NgFor],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent {

  private data: Data = new Data;
  categories: Category[] = this.data.all_categories;
}
