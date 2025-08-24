import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class Movieservice {
  private movies: Movie[] = [];

  getAll(): Movie[] {
    return this.movies;
  }

  addMovie(movie: Movie) {
    this.movies.push(movie);
  }

  updateMovie(movie: Movie) {
    const index = this.movies.findIndex(mov => mov.movieId === movie.movieId);
    if (index > -1) {
      this.movies[index] = movie;
    }
  }

  deleteMovie(id: number) {
    this.movies = this.movies.filter(mov => mov.movieId !== id);
  }
}

