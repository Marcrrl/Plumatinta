package com.proyecto.plumatinta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.plumatinta.model.Usuario;
import com.proyecto.plumatinta.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public void save(Usuario user) {
        usuarioRepository.save(user);
    }
}
