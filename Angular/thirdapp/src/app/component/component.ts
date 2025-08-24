import { CommonModule } from '@angular/common'
import { NgClass } from '@angular/common'
import { Component } from '@angular/core';
 
@Component({
  selector: 'app-component',
  imports: [CommonModule, NgClass],
  templateUrl: './component.html',
  styleUrl: './component.css'
})

export class AppComponent {
  flag1 = true;
  flag2 = true;
}
