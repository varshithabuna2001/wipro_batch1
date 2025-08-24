import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class Productservice {
   constructor(private http:HttpClient) { }

  getproduct():Observable<Product[]>  {
    let url:string="http://localhost:3000/products"
    return this.http.get<Product[]>(url);
  }
  
  addproduct(product: Product): Observable<Product> {
    let url:string="http://localhost:3000/products"
    return this.http.post<Product>(url, product);
  }
  deleteproduct(id: string): Observable<void> {
    let url:string=`http://localhost:3000/products/${id}`;
    return this.http.delete<void>(url);
  }

  findproduct(id: string): Observable<Product> {
    let url:string=`http://localhost:3000/products/${id}`;
    return this.http.get<Product>(url);
  }

  saveproduct(product: Product): Observable<Product> {
    let url:string=`http://localhost:3000/products/${product.id}`;
    return this.http.put<Product>(url, product);

}
}
  

