package com.proyecto.plumatinta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.plumatinta.model.Libro;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByGeneroId(Long generoId);
    List<Libro> findByAutor_Id(Long autorId);
    List<Libro> findByTitleContainingIgnoreCase(String title);
}