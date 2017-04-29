import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  public loginEvent(event: any, user: string, pass: string) {

    event.preventDefault();

    this.loginService.getLogin(user, pass).subscribe(
        u => this.router.navigate(['/']),
        error => alert('Invalid user or password')
    );
  }

  public logoutEvent() {
    this.loginService.getLogout().subscribe(
        response => { },
        error => console.log('Error when trying to log out: ' + error)
    );
  }

}
