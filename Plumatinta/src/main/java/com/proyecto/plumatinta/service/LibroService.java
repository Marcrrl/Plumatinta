package com.proyecto.plumatinta.service;

import com.proyecto.plumatinta.model.Libro;
import com.proyecto.plumatinta.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        List<Libro> libros = libroRepository.findAll();
        Collections.shuffle(libros);
        return libros;
    }

    public Libro findById(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.orElse(null);
    }

    public List<Libro> findByGenero(Long generoId) {
        return libroRepository.findByGeneroId(generoId);
    }

    public List<Libro> findByAutor(Long autorId) {
        return libroRepository.findByAutor_Id(autorId);
    }
}