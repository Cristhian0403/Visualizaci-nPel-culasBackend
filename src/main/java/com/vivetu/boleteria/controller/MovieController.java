package com.vivetu.boleteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivetu.boleteria.model.Movie;
import com.vivetu.boleteria.service.IMovieService;

@CrossOrigin // Permite que este controlador acepte solicitudes desde dominios externos (CORS).
@Validated  // Habilita la validación automática de los objetos recibidos en las solicitudes.
@RestController // Indica que esta clase maneja solicitudes HTTP y devuelve datos (JSON, por ejemplo).
@RequestMapping("/api") // Define la ruta base para todas las solicitudes manejadas por este controlador.
public class MovieController {

    @Autowired
    private IMovieService service; // Inyecta el servicio de películas para manejar la lógica de negocio.

    // Maneja solicitudes GET para listar películas, filtrando por estado activo, nombre, y orden.
    @GetMapping("/list")
    public List<Movie> list(@RequestParam(required = true) Integer active, 
            @RequestParam(required = false) String movieName,
            @RequestParam(required = false) Integer order) {
        int sortOrder = (order != null) ? order.intValue() : 0; // Define el orden, si no se especifica, es 0.
        return service.list(active, movieName, sortOrder); // Llama al servicio para obtener la lista de películas.
    }

    @PostMapping("/add")
    public int add(@Validated @RequestBody Movie m) {
        return service.add(m); // Valida y agrega la película mediante el servicio.
    }

    @GetMapping("/find")
    public Movie find(@RequestParam(required = true) Integer id) {
        return service.find(id); // Llama al servicio para encontrar la película con el ID proporcionado.
    }

    @PostMapping("/edit")
    public int update(@Validated @RequestBody Movie m) {
        return service.update(m); // Valida y actualiza la película mediante el servicio.
    }

    @GetMapping("/delete")
    public int delete(@RequestParam(required = true) Integer id) {
        return service.delete(id); // Llama al servicio para eliminar la película con el ID proporcionado.
    }
}
