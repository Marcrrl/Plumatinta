package com.proyecto.plumatinta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.plumatinta.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}