import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicle } from './vehicle';

@Injectable({
  providedIn: 'root'
})
export class Vehicles {
  private apiUrl = 'http://localhost:3000/vehicles';

  constructor(private http: HttpClient) {}

  // Get all vehicles
  getVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(this.apiUrl);
  }
}
