package com.vivetu.boleteria.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vivetu.boleteria.model.Movie;

@Repository
public class MovieDAO implements IMovie {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Movie> list(int role, String movieName, int order) {
        // Devuelve una lista de películas, filtradas por rol y nombre, y ordenadas según el criterio dado.
        String sql = "SELECT * FROM MOVIE WHERE (status = " + role + " OR " + role + " = 2)";

        if (movieName != null) {
            sql += " AND UPPER(name) like '%" + movieName + "%'";
        }
        switch (order) {
            case 1:
                sql += " ORDER BY score DESC";
                break;
            case 2:
                sql += " ORDER BY created_at DESC";
                break;
        }
        List<Movie> movies = template.query(sql, new BeanPropertyRowMapper<Movie>(Movie.class));
        return movies;
    }

    @Override
    public Movie find(int id) {
        // Busca una película por su ID en la base de datos y la devuelve.
        String sql = "SELECT * FROM movie WHERE movieid = ?";
        Movie mov = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
        return mov;
    }

    @Override
    public int add(Movie m) {
        // Agrega una nueva película a la base de datos.
        String sql = "INSERT INTO movie (name, image, description, status, score) VALUES (?,?,?,?,?)";
        int res = template.update(sql,
                m.getName(),
                m.getImage(),
                m.getDescription(),
                m.getStatus(),
                m.getScore());
        return res;
    }

    @Override
    public int update(Movie m) {
        // Actualiza los datos de una película existente en la base de datos.
        String sql = "UPDATE movie SET name = ?, image = ?, description = ?, status = ?, score = ? WHERE movieid = ?";
        int res = template.update(sql,
                m.getName(),
                m.getImage(),
                m.getDescription(),
                m.getStatus(),
                m.getScore(),
                m.getMovieid());
        return res;
    }

    @Override
    public int delete(int id) {
        // Elimina una película de la base de datos según su ID.
        String sql = "DELETE FROM movie WHERE movieid = ?";
        int res = template.update(sql, id);

        return res;
    }
}

