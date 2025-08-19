import { Component } from '@angular/core';

@Component({
  selector: 'app-countrylist',
  imports: [],
  templateUrl: './countrylist.html',
  styleUrl: './countrylist.css'
})
export class Countrylist {
 countries:string[] = ["India", "Switzerland", "France","Netherland"];
 loadedCountries: string[] = [];   

  loadCountries() {
    this.loadedCountries = [...this.countries];
}
}
