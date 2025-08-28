import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-reactive2',
  imports: [CommonModule,ReactiveFormsModule,MatFormFieldModule,MatInputModule,MatDatepickerModule,MatNativeDateModule,MatSelectModule,MatButtonModule],
  templateUrl: './reactive2.html',
  styleUrl: './reactive2.css'
})
export class Reactive2 {
subjects = ['English', 'Social', 'Mathematics', 'Physics', 'Biology'];
fg : FormGroup
 
  constructor(private fb: FormBuilder) {

  this.fg  = this.fb.group({
    name: ['', Validators.required],
    email: ['', Validators.required],
    dob: ['', Validators.required],
    subject: ['', Validators.required]
  });
}

  onSubmit() {
    alert(JSON.stringify(this.fg.value, null, 2));
  }
} 


