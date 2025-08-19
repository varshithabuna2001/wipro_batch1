import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-filter',
    imports: [FormsModule],
  templateUrl: './search-filter.html',
  styleUrl: './search-filter.css'
})
export class SearchFilter {
  names: string[] = ["AKshay", "Priya","Rudra","Prerna"];
  filteredNames: string[] = [...this.names];

  filterList(event: any) {
     const namefil=event.target.value.toLowerCase();
    this.filteredNames = this.names.filter(name =>
      name.toLowerCase().startsWith(namefil)
);
  }

}
