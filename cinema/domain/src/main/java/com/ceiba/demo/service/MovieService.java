package com.ceiba.demo.service;

import com.ceiba.demo.entity.Movie;
import com.ceiba.demo.exception.CinemaException;
import com.ceiba.demo.exception.MovieNotFoundException;
import com.ceiba.demo.port.MovieRepository;

public class MovieService {

    private static final String MESSAGE_ERROR_MOVIE_NOT_FOUND = "No se encontro pelicula a actualizar";

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findById(int id) {
        Movie movie = movieRepository.findById(id);
        if (movie == null) {
            throw new MovieNotFoundException("No se encontro pelicula");
        }
        return movie;
    }

    public void updateActive(int id, boolean active) {
        Movie movie = movieRepository.findById(id);
        if (movie == null) {
            throw new CinemaException(MESSAGE_ERROR_MOVIE_NOT_FOUND);
        }
    }

    public void delete(int id) {
        Movie movie = movieRepository.findById(id);
        movie.setActive(false);
        movie.setDeleted(true);
        movieRepository.update(movie);
    }

}
