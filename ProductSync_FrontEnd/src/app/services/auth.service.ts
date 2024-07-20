import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../../util/interfaces/models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  AUTH_URL: String = "https://product-sync.onrender.com/api"

  constructor(private httpClient: HttpClient) { }

  loginAdmin(login: Login) {
    return this.httpClient.post(`${this.AUTH_URL}/login`, login);
  }
}
