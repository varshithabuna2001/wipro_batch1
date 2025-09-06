import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

export interface Flight {
  id: string;
  airline: string;
  flightNumber: string;
  departureTime: string;
  arrivalTime: string;
  origin: string;
  destination: string;
  duration: string;
  price: number;
  nonStop: boolean;
}

export interface SearchCriteria {
  origin: string;
  destination: string;
  departureDate: string;
}

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  private searchCriteriaSubject = new BehaviorSubject<SearchCriteria | null>(null);
  private selectedFlightSubject = new BehaviorSubject<Flight | null>(null);
  private mockFlights: Flight[] = [
    {
      id: '1',
      airline: 'IndiGo',
      flightNumber: '6E 234',
      departureTime: '18:00',
      arrivalTime: '20:15',
      origin: 'Kolkata',
      destination: 'Chennai',
      duration: '02h 15m',
      price: 5650,
      nonStop: true
    },
    {
      id: '2',
      airline: 'IndiGo',
      flightNumber: '6E 723',
      departureTime: '21:00',
      arrivalTime: '23:15',
      origin: 'Kolkata',
      destination: 'Chennai',
      duration: '02h 15m',
      price: 5650,
      nonStop: true
    },
    {
      id: '3',
      airline: 'Air India',
      flightNumber: 'AI 785',
      departureTime: '17:00',
      arrivalTime: '19:30',
      origin: 'Kolkata',
      destination: 'Chennai',
      duration: '02h 30m',
      price: 5651,
      nonStop: true
    },
    {
      id: '4',
      airline: 'IndiGo',
      flightNumber: '6E 892',
      departureTime: '15:00',
      arrivalTime: '17:20',
      origin: 'Kolkata',
      destination: 'Chennai',
      duration: '02h 20m',
      price: 6385,
      nonStop: true
    }
  ];

  constructor() { }

  setSearchCriteria(criteria: SearchCriteria): void {
    this.searchCriteriaSubject.next(criteria);
  }

  getSearchCriteria(): Observable<SearchCriteria | null> {
    return this.searchCriteriaSubject.asObservable();
  }

  setSelectedFlight(flight: Flight): void {
    this.selectedFlightSubject.next(flight);
  }

  getSelectedFlight(): Observable<Flight | null> {
    return this.selectedFlightSubject.asObservable();
  }

  searchFlights(criteria: SearchCriteria): Flight[] {
    // In a real app, this would be an API call
    return this.mockFlights.filter(flight => 
      flight.origin.toLowerCase() === criteria.origin.toLowerCase() && 
      flight.destination.toLowerCase() === criteria.destination.toLowerCase()
    );
  }

  getFlightById(id: string): Flight | undefined {
    return this.mockFlights.find(flight => flight.id === id);
  }

  reverseRoute(criteria: SearchCriteria): SearchCriteria {
    return {
      origin: criteria.destination,
      destination: criteria.origin,
      departureDate: criteria.departureDate
    };
  }
}
