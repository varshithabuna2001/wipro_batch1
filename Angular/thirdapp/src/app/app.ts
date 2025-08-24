import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { home } from './home/home';

@Component({
  selector: 'app-root',
  imports: [home],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('thirdapp');
}
