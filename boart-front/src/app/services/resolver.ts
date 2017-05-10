import {Resolve, ActivatedRouteSnapshot} from "@angular/router";
import {LoginService} from "./login.service";
import {Injectable} from "@angular/core";
import {RequestOptions, Headers} from "@angular/http";
import {AjaxService} from "./ajax.service";
import {Observable} from "rxjs";

@Injectable()
export class UserResolve implements Resolve<any> {

    constructor(private loginService: LoginService, private ajaxService: AjaxService) {}

    resolve (route: ActivatedRouteSnapshot){

        const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });

        return this.ajaxService.getRequest('login', options).map(
            response => {
                this.loginService.isLogged = true;
            }
        ).subscribe(
            error => console.log(`Error: ${error}`)
        );
    }
}