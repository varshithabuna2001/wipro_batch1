import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService, Flight, Booking } from '../../services/flight.service';

@Component({
  selector: 'app-ticket',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ticket.html',
  styleUrl: './ticket.css'
})
export class TicketComponent implements OnInit {
  flight: Flight | undefined;
  booking: Booking | undefined;
  bookingReference: string = '';
  passengerName: string = '';
  bookingDate: Date = new Date();
  
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
            
            // Get booking information
            const bookings = this.flightService.getBookings();
            this.booking = bookings.find(b => b.flight.id === flightId);
            
            if (this.booking) {
              this.bookingReference = this.booking.bookingReference;
              this.passengerName = this.booking.passengerName;
              this.bookingDate = this.booking.bookingDate;
            }
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

  downloadTicket(): void {
    
    alert('Ticket download functionality would be implemented here.');
  }

  backToSearch(): void {
    this.router.navigate(['/search']);
  }
}