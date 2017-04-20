import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
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
  getRequest(endpoint): Observable<any> {

    let headers = new Headers({ 'Content-Type': 'application/json' });

    return this.http.get(this.buildUrl(endpoint), { headers: headers });

  }

  /**
   * postRequest - Generates ajax request.
   *
   * @param  {string} endpoint
   * @param  {object} body
   * @return {Observable}
   */
  postRequest(endpoint, body): Observable<any> {

    let headers = new Headers({ 'Content-Type': 'application/json' });

    return this.http.post(this.buildUrl(endpoint), body, { headers: headers });

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

    return this.http.get(this.buildUrl(endpoint), { headers: headers });

  }
}