import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface Payment {
  id?: number;
  bookingId: number;
  amount: number;
  method: string;    
  status?: string;   
}

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = `${environment.apiUrl}/payments`;  

  constructor(private http: HttpClient) {}

  
  makePayment(payment: Payment): Observable<Payment> {
    return this.http.post<Payment>(this.apiUrl, payment);
  }

  
  getPaymentByBooking(bookingId: number): Observable<Payment> {
    return this.http.get<Payment>(`${this.apiUrl}/booking/${bookingId}`);
  }
}
