import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('testapp');
  isPalindrome(word: string): boolean {
    let reversed = word.split('').reverse().join('');
    return word === reversed;
}
}
