import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Coldir } from './coldir';
import { Moviecomponent } from './moviecomponent/moviecomponent';


@Component({
  selector: 'app-root',
  imports:[FormsModule, CommonModule, Moviecomponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
 /* text = '';*/                   /*-----EXCERCISE 1----*/
/* selectedDate: any;  */               /*-----EXCERCISE 2----*/
title = 'fourthapp';
}
