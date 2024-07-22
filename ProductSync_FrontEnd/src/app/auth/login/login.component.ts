import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  loginForm: Login = {
    usernameOrEmail: "",
    password: ""
  }

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    if (localStorage.getItem('spring_token') != null) {
      this.router.navigate(["/home/"]);
      console.log("true");

    }
  }

  loginAdmin(): void {
    console.log(this.loginForm.usernameOrEmail + " " + this.loginForm.password);

    this.authService.loginAdmin(this.loginForm).subscribe({
      next: (response: any) =>{
        localStorage.setItem("spring_token", response.accessToken);
        this.router.navigate(["/home"]);
        return response;
      }
    })
    // this.router.navigate(["/home"]);
  }

}

interface Login {
  usernameOrEmail: String
  password: String
}
