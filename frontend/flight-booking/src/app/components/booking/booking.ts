import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService, Flight } from '../../services/flight.service';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './booking.html',
  styleUrl: './booking.css'
})
export class BookingComponent implements OnInit {
  flight: Flight | undefined;
  passengerName: string = 'John Doe'; // Hardcoded for demo
  passengerCount: number = 1;
  cabinBaggage: string = '7 Kg / Adult';
  checkInBaggage: string = '15 Kg / Adult';
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
        // No flight ID provided, redirect to search
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
