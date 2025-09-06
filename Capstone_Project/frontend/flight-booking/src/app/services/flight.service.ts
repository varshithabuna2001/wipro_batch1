import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

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
  private mockFlights: Flight[] = [
    {
      id: '1',
      airline: 'Air India',
      flightNumber: 'AI765',
      origin: 'Kolkata',
      destination: 'Chennai',
      departureTime: '17:00',
      arrivalTime: '19:30',
      duration: '2h 30m',
      price: 5651,
      seatsAvailable: 42
    },
    {
      id: '2',
      airline: 'IndiGo',
      flightNumber: '6E456',
      origin: 'Kolkata',
      destination: 'Chennai',
      departureTime: '10:00',
      arrivalTime: '12:30',
      duration: '2h 30m',
      price: 6385,
      seatsAvailable: 15
    },
    {
      id: '3',
      airline: 'SpiceJet',
      flightNumber: 'SG721',
      origin: 'Kolkata',
      destination: 'Chennai',
      departureTime: '12:00',
      arrivalTime: '14:30',
      duration: '2h 30m',
      price: 5651,
      seatsAvailable: 8
    },
    {
      id: '4',
      airline: 'IndiGo',
      flightNumber: '6E789',
      origin: 'Kolkata',
      destination: 'Chennai',
      departureTime: '21:00',
      arrivalTime: '23:30',
      duration: '2h 30m',
      price: 6440,
      seatsAvailable: 22
    }
  ];

  constructor() { }

  setSearchCriteria(criteria: SearchCriteria): void {
    this.searchCriteriaSubject.next(criteria);
    this.searchFlights(criteria);
  }

  getSearchCriteria(): Observable<SearchCriteria | null> {
    return this.searchCriteriaSubject.asObservable();
  }

  getFlights(): Observable<Flight[]> {
    return this.flightsSubject.asObservable();
  }

  private searchFlights(criteria: SearchCriteria): void {
    const filteredFlights = this.mockFlights.filter(flight => 
      flight.origin.toLowerCase().includes(criteria.origin.toLowerCase()) &&
      flight.destination.toLowerCase().includes(criteria.destination.toLowerCase())
    );
    
    this.flightsSubject.next(filteredFlights);
  }

  getFlightById(id: string): Flight | undefined {
    return this.mockFlights.find(flight => flight.id === id);
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