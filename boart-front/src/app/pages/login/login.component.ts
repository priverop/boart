import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router, private titleService: Title) { }

  ngOnInit() {
    this.titleService.setTitle("Boart - Login");
  }

  public loginEvent(event: any, user: string, pass: string) {

    event.preventDefault();

    this.loginService.getLogin(user, pass).subscribe(
        u => this.router.navigate(['/']),
        error => alert('Invalid user or password')
    );
  }
}
