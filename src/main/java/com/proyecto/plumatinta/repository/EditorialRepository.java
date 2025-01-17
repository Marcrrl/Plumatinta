package com.proyecto.plumatinta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.plumatinta.model.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    // ...existing code...
}
