import { Component } from '@angular/core';

@Component({
  selector: 'app-condicomp',
  imports: [],
  templateUrl: './condicomp.html',
  styleUrl: './condicomp.css'
})

export class Condicomp {
     flag=false;

     toggle()
     {
      this.flag=!this.flag;
     }
}
