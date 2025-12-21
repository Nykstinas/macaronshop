// ng g resolver resolvers/basket

import { Injectable } from '@angular/core';
import { Resolve } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class itemResolver implements Resolve<any> {

  constructor(private http: HttpClient) {}

  resolve(): Observable<any> {
    return this.http.get('http://localhost:8080/api/item/readItem');
  }
}
