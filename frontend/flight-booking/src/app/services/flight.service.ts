import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


export interface SearchCriteria {
  origin: string;
  destination: string;
  departureDate: string;
}

export interface Flight {
  id: string;
  airline: string;
  flightNumber: string;
  origin: string;
  destination: string;
  departureTime: string;
  arrivalTime: string;
  duration: string;
  price: number;
  seatsAvailable: number;
}

export interface Booking {
  bookingReference: string;
  flight: Flight;
  passengerName: string;
  paymentMethod: string;
  amount: number;
  bookingDate: Date;
}

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  private searchCriteriaSubject = new BehaviorSubject<SearchCriteria | null>(null);
  private flightsSubject = new BehaviorSubject<Flight[]>([]);

  
  private apiUrl = `${environment.apiUrl}/flights`;

  constructor(private http: HttpClient) { }

  
  setSearchCriteria(criteria: SearchCriteria): void {
    this.searchCriteriaSubject.next(criteria);

    this.searchFlights(criteria).subscribe((flights: Flight[]) => {
      this.flightsSubject.next(flights);
    });
  }

  getSearchCriteria(): Observable<SearchCriteria | null> {
    return this.searchCriteriaSubject.asObservable();
  }

  getFlights(): Observable<Flight[]> {
    return this.flightsSubject.asObservable();
  }

  
  searchFlights(criteria: SearchCriteria): Observable<Flight[]> {
    return this.http.get<Flight[]>(
      `${this.apiUrl}/search?source=${criteria.origin}&destination=${criteria.destination}`
    );
  }

  
  getFlightById(id: string): Observable<Flight> {
    return this.http.get<Flight>(`${this.apiUrl}/${id}`);
  }

  

  private bookings: Booking[] = [];
  private selectedFlightSubject = new BehaviorSubject<Flight | null>(null);

  setSelectedFlight(flight: Flight): void {
    this.selectedFlightSubject.next(flight);
  }

  getSelectedFlight(): Flight | null {
    return this.selectedFlightSubject.getValue();
  }

  saveBooking(booking: Booking): void {
    this.bookings.push(booking);

    try {
      const existingBookings = localStorage.getItem('bookings');
      let bookingsArray = existingBookings ? JSON.parse(existingBookings) : [];
      bookingsArray.push(booking);
      localStorage.setItem('bookings', JSON.stringify(bookingsArray));
    } catch (error) {
      console.error('Error saving booking to localStorage:', error);
    }
  }

  getBookings(): Booking[] {
    return this.bookings;
  }

  getBookingByReference(reference: string): Booking | undefined {
    return this.bookings.find(booking => booking.bookingReference === reference);
  }
}
