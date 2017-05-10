import {Injectable, OnInit, EventEmitter} from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { AjaxService } from './ajax.service';
import {CanActivate, Router} from '@angular/router';
import 'rxjs/Rx';

export interface User {
  id?: number;
  name: string;
  roles: string[];
}

@Injectable()
export class LoginService {

  isLogged = false;
  user: User;

  constructor(private http: Http, private ajaxService: AjaxService, private router: Router) {
    this.reqIsLogged();
  }

  x () {
      const headers = new Headers({
          'X-Requested-With': 'XMLHttpRequest'
      });

      const options = new RequestOptions({ withCredentials: true, headers });

      return this.ajaxService.getRequest('login', options);
  }

  reqIsLogged() {

    const headers = new Headers({
      'X-Requested-With': 'XMLHttpRequest'
    });

    const options = new RequestOptions({ withCredentials: true, headers });

    this.ajaxService.getRequest('login', options).subscribe(
        response => this.processLogInResponse(response),
        error => {}
    );
  }

  private processLogInResponse(response) {
    this.isLogged = true;
    this.user = response.json();
  }

  getLogin(user: string, pass: string) {

    const userPass = user + ':' + pass;

    const headers = new Headers({
      'Authorization': 'Basic ' + utf8_to_b64(userPass),
      'X-Requested-With': 'XMLHttpRequest'
    });

    const options = new RequestOptions({ withCredentials: true, headers });

    return this.ajaxService.getRequest('login', options).map(
        response => {
          this.processLogInResponse(response);
          return this.user;
        }
    );
  }

  getLogout() {

    return this.ajaxService.getRequest('logout', { withCredentials: true }).map(
        response => {
          this.isLogged = false;
          return response;
        }
    );
  }

  canActivate() {
      if(!this.isLogged) {
          this.router.navigate(['/login']);
      }
      return this.isLogged;
  }
}

function utf8_to_b64(str) {
  return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function (match, p1) {
    return String.fromCharCode(<any>'0x' + p1);
  }));
}
