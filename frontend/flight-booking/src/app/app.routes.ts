import { Routes } from '@angular/router';
import { SearchComponent } from './components/search/search';
import { SearchResultsComponent } from './components/search-results/search-results';
import { BookingComponent } from './components/booking/booking';
import { PaymentComponent } from './components/payment/payment';
import { TicketComponent } from './components/ticket/ticket';
import { PaymentFailedComponent } from './components/payment-failed/payment-failed';

export const routes: Routes = [
  { path: '', redirectTo: 'search', pathMatch: 'full' },
  { path: 'search', component: SearchComponent },
  { path: 'search-results', component: SearchResultsComponent },
  { path: 'booking/:id', component: BookingComponent },
  { path: 'payment/:id', component: PaymentComponent },
  { path: 'ticket/:id', component: TicketComponent },
  { path: 'payment-failed', component: PaymentFailedComponent },
  { path: '**', redirectTo: 'search' }
];
