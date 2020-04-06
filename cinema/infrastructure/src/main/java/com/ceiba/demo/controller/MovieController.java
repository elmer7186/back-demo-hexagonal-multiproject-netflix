package com.ceiba.demo.controller;

import com.ceiba.demo.command.CreateMovieCommand;
import com.ceiba.demo.command.DeleteMovieCommand;
import com.ceiba.demo.command.UpdateActiveCommand;
import com.ceiba.demo.command.UpdateMovieCommand;
import com.ceiba.demo.entity.Movie;
import com.ceiba.demo.entity.MovieDto;
import com.ceiba.demo.query.GetMoviesListQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private CreateMovieCommand createMovieCommand;
    private UpdateMovieCommand updateCommandHandler;
    private GetMoviesListQuery getMoviesListQuery;
    private DeleteMovieCommand deleteMovieCommand;
    private UpdateActiveCommand updateActiveCommand;

    public MovieController(CreateMovieCommand createMovieCommand, UpdateMovieCommand updateCommandHandler,
                           GetMoviesListQuery getMoviesListQuery, DeleteMovieCommand deleteMovieCommand,
                           UpdateActiveCommand updateActiveCommand) {
        this.createMovieCommand = createMovieCommand;
        this.updateCommandHandler = updateCommandHandler;
        this.getMoviesListQuery = getMoviesListQuery;
        this.deleteMovieCommand = deleteMovieCommand;
        this.updateActiveCommand = updateActiveCommand;
    }

    @PostMapping
    public void save(@RequestBody MovieDto movieDto) {
        createMovieCommand.handler(movieDto);
    }

    @GetMapping
    public Collection<Movie> getAllMovies() {
        return getMoviesListQuery.handler();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        deleteMovieCommand.handler(id);
    }

    @PatchMapping(value = "/{id}/{active}")
    public void updateActive(@PathVariable("id") int id, @PathVariable("active") boolean active) {
        updateActiveCommand.handler(id, active);
    }

    @PutMapping
    public void update(@RequestBody MovieDto movieDto) {
        this.updateCommandHandler.handler(movieDto);
    }
}
