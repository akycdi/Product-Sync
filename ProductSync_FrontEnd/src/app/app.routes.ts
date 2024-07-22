import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { ProductsComponent } from './products/products.component';
import { CategoriesComponent } from './categories/categories.component';
import { HomeComponent } from './home/home.component';
import { BarChartComponent } from './graphs/bar-chart/bar-chart.component';
import { GraphsComponent } from './graphs/graphs.component';
import { PieChartComponent } from './graphs/pie-chart/pie-chart.component';
import { ViewProductComponent } from './products/view-product/view-product.component';

export const routes: Routes = [
    { path: "login", component: LoginComponent },
    { path: "home", component: HomeComponent, children: [
        { path: "products", component: ProductsComponent },
        { path: "products/:id", component: ViewProductComponent },
        { path: "categories", component: CategoriesComponent },
        { path: "graphs", component: GraphsComponent, children: [
            // { path: "bar-chart", component: BarChartComponent },
            // { path: "pie-chart", component: PieChartComponent }
        ] },
        { path: "", redirectTo: "products", pathMatch: "full" }
    ] },
    { path: "", redirectTo: "login", pathMatch: "full" }
];
