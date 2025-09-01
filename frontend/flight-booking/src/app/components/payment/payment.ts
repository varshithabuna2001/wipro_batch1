import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService, Flight } from '../../services/flight.service';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payment.html',
  styleUrl: './payment.css'
})
export class PaymentComponent implements OnInit {
  flight: Flight | undefined;
  totalAmount: number = 0;
  paymentMethod: string = 'card';
  
  // Card details
  cardNumber: string = '';
  cardholderName: string = '';
  expiryMonth: string = '';
  expiryYear: string = '';
  cvv: string = '';
  saveCardInfo: boolean = false;
  
  
  isProcessing: boolean = false;
  paymentError: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private flightService: FlightService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const flightId = params.get('id');
      if (flightId) {
        this.flightService.getFlightById(flightId).subscribe({
          next: (flight) => {
            this.flight = flight;
            
            // Calculate total amount
            this.totalAmount = this.flight.price;
          },
          error: (error) => {
            console.error('Error fetching flight:', error);
            // Flight not found, redirect to search
            this.router.navigate(['/search']);
          }
        });
      } else {
        
        this.router.navigate(['/search']);
      }
    });
  }

  selectPaymentMethod(method: string): void {
    this.paymentMethod = method;
  }

  processPayment(): void {
    
    this.paymentError = null;
    
    
    if (this.paymentMethod === 'card') {
      if (!this.validateCardDetails()) {
        return;
      }
    }
    
    
    this.isProcessing = true;
    
    
    setTimeout(() => {
      this.isProcessing = false;
      
      
      const success = Math.random() > 0.2; 
      
      if (success && this.flight) {
        
        this.router.navigate(['/ticket', this.flight.id]);
      } else {
        
        this.paymentError = 'Payment failed. Please try again.';
        
        this.router.navigate(['/payment-failed']);
      }
    }, 2000);
  }

  private validateCardDetails(): boolean {
    if (!this.cardNumber || this.cardNumber.length < 16) {
      this.paymentError = 'Please enter a valid card number';
      return false;
    }
    
    if (!this.cardholderName) {
      this.paymentError = 'Please enter the cardholder name';
      return false;
    }
    
    if (!this.expiryMonth || !this.expiryYear) {
      this.paymentError = 'Please enter a valid expiry date';
      return false;
    }
    
    if (!this.cvv || this.cvv.length < 3) {
      this.paymentError = 'Please enter a valid CVV';
      return false;
    }
    
    return true;
  }
}