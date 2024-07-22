import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) { }

  ordersChart(): Observable<any> {
    return this.http.get('http://localhost:8080/api/statistics/orders');
  }

  locationChart(): Observable<any> {
    return this.http.get('http://localhost:8080/api/statistics/locations');
  }

  productsChart(): Observable<any> {
    return this.http.get('http://localhost:8080/api/statistics/products');
  }
}
