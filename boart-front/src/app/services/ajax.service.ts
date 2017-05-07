import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { environment } from '../../environments/environment';

import 'rxjs/add/operator/toPromise';
import { Observable } from "rxjs";


@Injectable()
export class AjaxService {

  private urlBase: string;

  constructor(public http: Http) {
    this.urlBase = environment.api.url;
  }

  /**
   * buildUrl - Build all the url with the base and the variable.
   *
   * @param  {string} endpoint
   * @return {string}
   */
  buildUrl(endpoint) {

    if (endpoint.param) {
      return this.urlBase + endpoint.id + '/' + endpoint.param;
    }
    return this.urlBase + endpoint;
  }

  /**
   * getRequest - Generates ajax request.
   *
   * @param  {string} endpoint
   * @return {Observable}
   */
  getRequest(endpoint, options?): Observable<any> {

    if(options) {
      return this.http.get(this.buildUrl(endpoint), options);
    }

    let headers = new Headers({ 'Content-Type': 'application/json' });

    return this.http.get(this.buildUrl(endpoint), { headers: headers });

  }

  /**
   * getRequest - Generates ajax request.
   *
   * @param  {string} endpoint
   * @return {Observable}
   */
  getRequestCredentials(endpoint): Observable<any> {

    let headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
    let options = new RequestOptions({ headers: headers, withCredentials: true }); //Necesario para que siga mandando el JSESSIONID

    return this.http.get(this.buildUrl(endpoint), options);

  }

  /**
   * postRequest - Generates ajax request.
   *
   * @param  {string} endpoint
   * @param  {object} body
   * @return {Observable}
   */
  postRequest(endpoint, body): Observable<any> {

    let headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
    let options = new RequestOptions({ headers: headers, withCredentials: true }); //Necesario para que siga mandando el JSESSIONID
    return this.http.post(this.buildUrl(endpoint), body, options);

  }
  
  multipartRequest(endpoint, body): Observable<any> {

    let options = new RequestOptions({withCredentials: true }); //Necesario para que siga mandando el JSESSIONID
    return this.http.post(this.buildUrl(endpoint), body, options);

  }

  /**
   * putRequest - Generates ajax request.
   *
   * @param  {string} endpoint
   * @param  {object} body
   * @return {Observable}
   */
  putRequest(endpoint, body): Observable<any> {

    let headers = new Headers({ 'Content-Type': 'application/json' });

    return this.http.post(this.buildUrl(endpoint), body, { headers: headers });

  }

  /**
   * deleteRequest - Generates ajax request.
   *
   * @param  {string} endpoint
   * @return {Observable}
   */
  deleteRequest(endpoint): Observable<any> {

    let headers = new Headers({ 'Content-Type': 'application/json' });

    return this.http.delete(this.buildUrl(endpoint), { headers: headers, withCredentials: true });

  }
}
