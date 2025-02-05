package com.proyecto.plumatinta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.plumatinta.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    // ...existing code...
}
