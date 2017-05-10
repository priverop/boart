import {Resolve, ActivatedRouteSnapshot} from "@angular/router";
import {LoginService} from "./login.service";
import {Injectable} from "@angular/core";
import {RequestOptions, Headers} from "@angular/http";
import {AjaxService} from "./ajax.service";
import {Observable} from "rxjs";
import 'rxjs/add/operator/catch'

@Injectable()
export class UserResolve implements Resolve<any> {

    constructor(private loginService: LoginService, private ajaxService: AjaxService) {}

    resolve (route: ActivatedRouteSnapshot): Promise<any>{

        const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });

        return this.ajaxService.getRequest('login', options).map(
            response => {
                console.log(response.json());
                this.loginService.user = response.json();
                this.loginService.isLogged = true;
            }
        ).toPromise().catch(err => {
            console.log(err)
        })
    }
}