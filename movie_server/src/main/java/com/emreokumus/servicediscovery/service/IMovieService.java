package com.emreokumus.servicediscovery.service;

import com.emreokumus.servicediscovery.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAllMovies();
}
