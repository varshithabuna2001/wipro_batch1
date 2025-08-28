import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormControl } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';


@Component({
  selector: 'app-reactive1',
  imports: [CommonModule, ReactiveFormsModule, MatInputModule],
  templateUrl: './reactive1.html',
  styleUrl: './reactive1.css'
})
export class Reactive1 {
  title = 'Reverse';
  textControl = new FormControl('');
  reversedText: string = '';

  constructor() {
    this.textControl.valueChanges.subscribe(value => {
      this.reversedText = value?.split('').reverse().join('') ?? '';
    });
  }
  }
