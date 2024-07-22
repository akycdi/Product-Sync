import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  isUserActive: Boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    if (localStorage.getItem('spring_token') == null) {
      this.router.navigate(["/login"]);
    } else {
      this.isUserActive = true;
    }
  }

  public toLogin(): void {
    this.router.navigateByUrl(`/login`);

}
}
