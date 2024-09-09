package com.vivetu.boleteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivetu.boleteria.model.Movie;
import com.vivetu.boleteria.repository.IMovie;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovie dao;

    @Override
    public List<Movie> list(int role, String movieName, int order) {
        return dao.list(role, movieName, order);
    }

    @Override
    public Movie find(int id) {
        return dao.find(id);
    }

    @Override
    public int add(Movie m) {
        dao.add(m);
        return 0;
    }

    @Override
    public int update(Movie m) {
        dao.update(m);
        return 0;
   }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

}
