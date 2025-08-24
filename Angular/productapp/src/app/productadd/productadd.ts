import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Productservice } from '../productservice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-productadd',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './productadd.html',
  styleUrls: ['./productadd.css']
})
export class Productadd {
  productName: string = '';
  productCategory: string = '';
  productPrice: number = 0;

  constructor(private productService: Productservice, private router: Router) {}

  submit() {
    console.log('Adding product:', this.productName, this.productCategory, this.productPrice);

    this.productService.addproduct({
      name: this.productName,
      category: this.productCategory,
      price: Number(this.productPrice)
    }).subscribe({
      next: (response) => {
        console.log('Product added successfully:', response);
        this.router.navigate(['/productlist']);
      },
      error: (error) => {
        console.error('Error adding product:', error);
      }
    });
  }
}
