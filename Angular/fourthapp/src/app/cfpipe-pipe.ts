import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cfpipe'
})
export class CfpipePipe implements PipeTransform {

  transform(value: number): string {
    const fahrenheit = (value * 9/5) + 32;
    return `${fahrenheit}F`;
  }

}
