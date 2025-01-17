package com.proyecto.plumatinta.controller;

import com.proyecto.plumatinta.model.Usuario;
import com.proyecto.plumatinta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getContraseña().equals(password)) {
            return "redirect:/";
        } else {
            return "redirect:/login?error=invalidCredentials";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String nombre, @RequestParam String apellidos, @RequestParam String email,
            @RequestParam String dni, @RequestParam String direccion, @RequestParam String telefono,
            @RequestParam String password, @RequestParam String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return "redirect:/register?error=passwordsDoNotMatch";
        }

        if (usuarioRepository.findByEmail(email) != null) {
            return "redirect:/register?error=emailAlreadyExists";
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setDni(dni);
        usuario.setDireccion(direccion);
        usuario.setTelefono(telefono);
        usuario.setContraseña(password);
        usuario.setRol("cliente");
        usuarioRepository.save(usuario);

        return "redirect:/";
    }
}
