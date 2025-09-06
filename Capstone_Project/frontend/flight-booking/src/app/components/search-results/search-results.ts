import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService, Flight, SearchCriteria } from '../../services/flight.service';

@Component({
  selector: 'app-search-results',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './search-results.html',
  styleUrl: './search-results.css'
})
export class SearchResultsComponent implements OnInit {
  flights: Flight[] = [];
  filteredFlights: Flight[] = [];
  searchCriteria: SearchCriteria | null = null;
  noFlightsFound = false;
  
  
  filters = {
    airlines: [] as string[],
    minPrice: 0,
    maxPrice: 10000,
    departureTime: {
      morning: false, 
      afternoon: false, 
      evening: false, 
    }
  };
  
  
  selectedAirlines: string[] = [];
  selectedDepartureTimes: string[] = [];

  constructor(
    private flightService: FlightService,
    private router: Router
  ) {}

  ngOnInit(): void {
    
    this.flightService.getSearchCriteria().subscribe(criteria => {
      this.searchCriteria = criteria;
      
      
      if (!criteria) {
        this.router.navigate(['/search']);
        return;
      }
    });
    
    
    this.flightService.getFlights().subscribe(flights => {
      this.flights = flights;
      this.filteredFlights = [...flights];
      this.noFlightsFound = this.filteredFlights.length === 0;
      
      
      this.filters.airlines = [...new Set(flights.map(flight => flight.airline))];
      
      
      if (flights.length > 0) {
        this.filters.minPrice = Math.min(...flights.map(flight => flight.price));
        this.filters.maxPrice = Math.max(...flights.map(flight => flight.price));
      }
    });
  }

  applyFilters(): void {
    this.filteredFlights = this.flights.filter(flight => {
      
      if (this.selectedAirlines.length > 0 && !this.selectedAirlines.includes(flight.airline)) {
        return false;
      }
      
      
      if (this.selectedDepartureTimes.length > 0) {
        const hour = parseInt(flight.departureTime.split(':')[0]);
        
        const isMorning = hour >= 6 && hour < 12;
        const isAfternoon = hour >= 12 && hour < 18;
        const isEvening = hour >= 18 || hour < 6;
        
        const timeMatch = 
          (this.selectedDepartureTimes.includes('morning') && isMorning) ||
          (this.selectedDepartureTimes.includes('afternoon') && isAfternoon) ||
          (this.selectedDepartureTimes.includes('evening') && isEvening);
          
        if (!timeMatch) {
          return false;
        }
      }
      
      return true;
    });
    
    this.noFlightsFound = this.filteredFlights.length === 0;
  }

  clearFilters(): void {
    this.selectedAirlines = [];
    this.selectedDepartureTimes = [];
    this.filteredFlights = [...this.flights];
    this.noFlightsFound = this.filteredFlights.length === 0;
  }

  toggleAirlineFilter(airline: string): void {
    const index = this.selectedAirlines.indexOf(airline);
    if (index === -1) {
      this.selectedAirlines.push(airline);
    } else {
      this.selectedAirlines.splice(index, 1);
    }
    this.applyFilters();
  }

  toggleDepartureTimeFilter(time: string): void {
    const index = this.selectedDepartureTimes.indexOf(time);
    if (index === -1) {
      this.selectedDepartureTimes.push(time);
    } else {
      this.selectedDepartureTimes.splice(index, 1);
    }
    this.applyFilters();
  }

  selectFlight(flight: Flight): void {
    this.router.navigate(['/booking', flight.id]);
  }
}
