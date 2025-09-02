import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../../services/flight.service';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './search.html',
  styleUrl: './search.css'
})
export class SearchComponent implements OnInit {
  searchForm!: FormGroup;
  today: string;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private flightService: FlightService
  ) {
    
    const date = new Date();
    this.today = date.toISOString().split('T')[0];
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {
    this.searchForm = this.fb.group({
      origin: ['', [Validators.required, Validators.minLength(3)]],
      destination: ['', [Validators.required, Validators.minLength(3)]],
      departureDate: [this.today, Validators.required]
    });
  }

  swapLocations(): void {
    const origin = this.searchForm.get('origin')?.value;
    const destination = this.searchForm.get('destination')?.value;
    
    this.searchForm.patchValue({
      origin: destination,
      destination: origin
    });
  }

  onSubmit(): void {
    if (this.searchForm.invalid) {
      
      Object.keys(this.searchForm.controls).forEach(key => {
        const control = this.searchForm.get(key);
        control?.markAsTouched();
      });
      return;
    }

    
    this.flightService.setSearchCriteria(this.searchForm.value);
    
    
    this.router.navigate(['/search-results']);
  }
}
