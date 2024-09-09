package com.vivetu.boleteria.repository;

import java.util.List;

import com.vivetu.boleteria.model.Movie;

public interface IMovie {
    public List<Movie> list(int role, String movieName, int order);

    public Movie find(int id);

    public int add(Movie m);

    public int update(Movie m);

    public int delete(int id);
}
