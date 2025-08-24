import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appColdir]'
})
export class Coldir {

  constructor(private el: ElementRef) {
    this.el.nativeElement.style.color = 'yellow';
    this.el.nativeElement.style.textDecoration = 'line-through';
  }
}
