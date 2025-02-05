package com.proyecto.plumatinta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.plumatinta.service.LibroService;
import com.proyecto.plumatinta.model.Libro;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String getLibros(Model model) {
        model.addAttribute("libros", libroService.findAll());
        return "index";
    }

    @GetMapping("/libro/{id}")
@ResponseBody
public Libro getLibroById(@PathVariable Long id) {
    Libro libro = libroService.findById(id);
    if (libro == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado");
    }
    return libro;
}

    @GetMapping("/genero/{id}")
    public String getLibrosByGenero(@PathVariable Long id, Model model) {
        model.addAttribute("libros", libroService.findByGenero(id));
        return "index";
    }

    @GetMapping("/autor/{id}")
    public String getLibrosByAutor(@PathVariable Long id, Model model) {
        model.addAttribute("libros", libroService.findByAutor(id));
        return "index";
    }

    @GetMapping("/libros/genero/{id}")
    @ResponseBody
    public List<Libro> getLibrosByGenero(@PathVariable Long id) {
        return libroService.findByGenero(id);
    }

    @GetMapping("/libros/autor/{id}")
    @ResponseBody
    public List<Libro> getLibrosByAutor(@PathVariable Long id) {
        return libroService.findByAutor(id);
    }

    @GetMapping("/libros/buscar")
    @ResponseBody
    public List<Libro> buscarLibros(@RequestParam String query) {
        return libroService.buscarLibrosPorTitulo(query);
    }
}
