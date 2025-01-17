package com.proyecto.plumatinta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.plumatinta.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
