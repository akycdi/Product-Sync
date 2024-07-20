import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BarChartComponent } from "./bar-chart/bar-chart.component";
import { PieChartComponent } from './pie-chart/pie-chart.component';

@Component({
  selector: 'app-graphs',
  standalone: true,
  imports: [RouterModule, BarChartComponent, PieChartComponent],
  templateUrl: './graphs.component.html',
  styleUrl: './graphs.component.css'
})
export class GraphsComponent {

}
