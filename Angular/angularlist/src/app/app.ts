import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatListModule } from '@angular/material/list';
import { Reactive1 } from './reactive1/reactive1';
import { Reactive2 } from './reactive2/reactive2';

 @Component({
  selector: 'app-root',
  imports: [CommonModule, Reactive2],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  /*title = 'City List App';
  cities: string[] = [
    'Hyderabad',
    'Chennai',
    'Banglore',
    'Pune',
    'Lucknow',
    'Vishakapatnam',
    'Mumbai'
  ];*/
}

