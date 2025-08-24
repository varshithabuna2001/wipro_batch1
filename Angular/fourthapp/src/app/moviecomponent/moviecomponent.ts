import { Component } from '@angular/core';
import { Movie } from '../movie';
import { Movieservice } from '../movieservice';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-moviecomponent',
  imports :[FormsModule,CommonModule],
  providers : [Movieservice],
  templateUrl: './moviecomponent.html',
  styleUrl: './moviecomponent.css'
})
export class Moviecomponent {
  movie: Movie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };

  constructor(public movieService: Movieservice) {}

  add() {
    this.movieService.addMovie({...this.movie});
    this.reset();
  }

  update() {
    this.movieService.updateMovie({...this.movie});
    this.reset();
  }

  delete(id: number) {
    this.movieService.deleteMovie(id);
  }

  edit(mov: Movie) {
    this.movie = {...mov};
  }

  reset() {
    this.movie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
  }

}
