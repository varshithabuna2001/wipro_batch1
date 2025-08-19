import { Component } from '@angular/core';

interface Book {
  title: string;
  description: string;
  image: string;
}

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  books: Book[] = [];
}
