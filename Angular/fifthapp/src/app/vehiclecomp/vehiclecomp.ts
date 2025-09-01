import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../vehicle';
import { Vehicles } from '../vehicles';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-vehiclecomp',
  imports: [FormsModule, CommonModule],
  templateUrl: './vehiclecomp.html',
  styleUrl: './vehiclecomp.css'
})

export class Vehiclecomp {
     vehicles: Vehicle[] = [];

  constructor(private vehicleService: Vehicles) {}

  ngOnInit(): void {
    this.vehicles.getVehicles().subscribe((data: Vehicle[]) => {
      this.vehicles = data;
    });
  }

}
