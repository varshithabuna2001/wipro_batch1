import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'secondcomp',
  imports: [RouterOutlet],
  templateUrl: './secondcomp.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('newapp');
}
