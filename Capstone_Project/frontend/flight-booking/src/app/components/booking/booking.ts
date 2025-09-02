import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService, Flight } from '../../services/flight.service';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './booking.html',
  styleUrl: './booking.css'
})
export class BookingComponent implements OnInit {
  flight: Flight | undefined;
  passengerName: string = ' '; 
  age: number |null = null;
  gender: string = ' ';
  totalAmount: number = 0;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private flightService: FlightService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const flightId = params.get('id');
      if (flightId) {
        this.flight = this.flightService.getFlightById(flightId);
        
        if (!this.flight) {
          
          this.router.navigate(['/search']);
          return;
        }
        
        
        this.totalAmount = this.flight.price;
      } else {
        
        this.router.navigate(['/search']);
      }
    });
  }

  proceedToPayment(): void {
    if (this.flight) {
      this.router.navigate(['/payment', this.flight.id]);
    }
  }
}
