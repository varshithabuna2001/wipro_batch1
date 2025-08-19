import { Component } from '@angular/core';

@Component({
  selector: 'app-changecol',
  imports: [],
  templateUrl: './changecol.html',
  styleUrl: './changecol.css'
})
export class Changecol {
  selectedColor = 'black';

  changeColor(event: any) {
    this.selectedColor = event.target.value;
  }

}
