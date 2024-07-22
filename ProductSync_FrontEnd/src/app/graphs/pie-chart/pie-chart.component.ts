import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { StatisticsService } from '../../services/statistics.service';

@Component({
  selector: 'app-pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css'],
  standalone: true,
  imports: [BaseChartDirective],
})
export class PieChartComponent implements OnInit {

  constructor(private statisticsService: StatisticsService) {}

  @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;

  // Pie
  public pieChartOptions: ChartConfiguration['options'] = {
    plugins: {
      legend: {
        display: true,
        position: 'top',
      },
    },
  };
  public pieChartData: ChartData<'pie', number[], string | string[]> = {
    datasets: [{
      data: []
    }],
    labels: [],
  };
  public pieChartType: ChartType = 'pie';

  ngOnInit(): void {
    this.statisticsService.locationChart().subscribe({
      next: (response: any) => {
        this.pieChartData.datasets[0].data = response.data;
        this.pieChartData.labels = response.labels;

        this.chart?.update();
      }
    })

    console.log(this.pieChartData)
  }

  // events
  public chartClicked({
    event,
    active,
  }: {
    event: ChartEvent;
    active: object[];
  }): void {
    console.log(event, active);
  }

  public chartHovered({
    event,
    active,
  }: {
    event: ChartEvent;
    active: object[];
  }): void {
    console.log(event, active);
  }
}
