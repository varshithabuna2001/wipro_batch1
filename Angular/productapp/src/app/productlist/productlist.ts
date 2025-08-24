import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { Productservice } from '../productservice';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-productlist',
  imports :[CommonModule],
  templateUrl: './productlist.html',
  styleUrls: ['./productlist.css']   
})
export class Productlist implements OnInit {
  products: Product[] = [];

  constructor(private productService: Productservice, private router: Router) {}

  ngOnInit() {
    console.log("==> productlist Component Initialized");

    this.productService.getproduct().subscribe(
      (data: Product[]) => {
        this.products = data;
        console.log('Products fetched successfully:', data);
      },
      (error) => {
        console.error('Error fetching products:', error);
      }
    );
  }

  addproduct() {
    this.router.navigate(['/productadd']);
  }
}
