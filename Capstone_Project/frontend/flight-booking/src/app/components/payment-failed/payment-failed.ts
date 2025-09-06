import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-failed',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './payment-failed.html',
  styleUrl: './payment-failed.css'
})
export class PaymentFailedComponent {
  constructor(private router: Router) {}

  tryAgain(): void {
    this.router.navigate(['/search-results']);
  }

  backToSearch(): void {
    this.router.navigate(['/search']);
  }
}
