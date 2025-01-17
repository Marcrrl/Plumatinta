package com.proyecto.plumatinta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.plumatinta.model.LineaPedido;

@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Long> {
    // ...existing code...
}
