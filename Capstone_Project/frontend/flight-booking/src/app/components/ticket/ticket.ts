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
        this.flight = this.flightService.getFlightById(flightId);
        
        if (!this.flight) {
          
          this.router.navigate(['/search']);
          return;
        }
        
        
        const bookings = this.flightService.getBookings();
        this.booking = bookings.find(b => b.flight.id === flightId);
        
        if (this.booking) {
          this.bookingReference = this.booking.bookingReference;
          this.passengerName = this.booking.passengerName;
          this.bookingDate = this.booking.bookingDate;
        }
      } else {
        
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
