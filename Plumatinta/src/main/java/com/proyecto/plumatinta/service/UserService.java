package com.proyecto.plumatinta.service;

import com.proyecto.plumatinta.model.Usuario;

public interface UserService {
    boolean existsByEmail(String email);

    void save(Usuario user);
}
