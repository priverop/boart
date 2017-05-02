import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from "@angular/router";


@Component({
  selector: 'app-header',
  templateUrl: './app-header.component.html',
  styleUrls: ['./app-header.component.scss'],
})
export class AppHeaderComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  public logoutEvent() {
    this.loginService.getLogout().subscribe(
        response => {this.router.navigate(['/'])},
        error => console.log('Error when trying to log out: ' + error)
    );
  }

}
