import { Component, OnInit } from '@angular/core';
import {AjaxService} from "../../services/ajax.service";
import {Router} from "@angular/router";
import {URLSearchParams} from "@angular/http";
import {LoginService} from "../../services/login.service";
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private ajaxService: AjaxService, private router: Router, private loginService: LoginService, private titleService: Title) { }

  ngOnInit() {
    this.titleService.setTitle("Boart - Registro");
  }

  registerEvent(event: any, name: string, surname: string, username: string, mail: string, password: string) {

    let formData = new URLSearchParams();

    formData.set('name', name);
    formData.set('surname', surname);
    formData.set('username', username);
    formData.set('mail', mail);
    formData.set('password', password);

    let endpoint = 'user';

    this.ajaxService.postRequest(endpoint, formData).subscribe(
        response => {
          this.loginService.getLogin(username, password).subscribe(
              u => this.router.navigate(['/']),
              error => alert('Invalid user or password')
          );
        },
        error => alert('Invalid register')
    );
  }

}
