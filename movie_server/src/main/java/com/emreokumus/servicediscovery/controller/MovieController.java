package com.emreokumus.servicediscovery.controller;

import com.emreokumus.servicediscovery.model.Movie;
import com.emreokumus.servicediscovery.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/list")
    public List<Movie> getAllMovies(){
        return movieService.findAllMovies();
    }
}
