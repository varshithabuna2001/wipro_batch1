import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Productservice } from '../productservice';

@Component({
  selector: 'app-productdelete',
  imports: [],
  templateUrl: './productdelete.html',
  styleUrl: './productdelete.css'
})
export class Productdelete {
   id:string | null = null;
  constructor(private activeRoute:ActivatedRoute,private productService:Productservice,private router:Router) {
   }
   ngOnInit() {
         this.id = this.activeRoute.snapshot.paramMap.get('id');
         console.log("User to be deleted has id:", this.id);
         this.productService.deleteproduct(this.id!).subscribe(response => {
           console.log('User deleted successfully');
           this.router.navigate(['/userlist']); 
         }, error => {
           console.error('Error deleting user:', error);
          
         }  );
   }

}

