package com.proyecto.plumatinta.controller;

import com.proyecto.plumatinta.model.Usuario;
import com.proyecto.plumatinta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
            RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && passwordEncoder.matches(password, usuario.getContraseña())) {
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Email o contraseña incorrectos.");
            return "redirect:/login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String nombre, @RequestParam String apellidos, @RequestParam String email,
            @RequestParam String dni, @RequestParam String direccion, @RequestParam String telefono,
            @RequestParam String password, @RequestParam String confirmPassword,
            RedirectAttributes redirectAttributes) {
        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden.");
            return "redirect:/register";
        }

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            redirectAttributes.addFlashAttribute("error", "Formato de email inválido.");
            return "redirect:/register";
        }

        if (usuarioRepository.findByEmail(email) != null) {
            redirectAttributes.addFlashAttribute("error", "El email ya está registrado.");
            return "redirect:/register";
        }

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
            redirectAttributes.addFlashAttribute("error", "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número.");
            return "redirect:/register";
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setDni(dni);
        usuario.setDireccion(direccion);
        usuario.setTelefono(telefono);
        usuario.setContraseña(passwordEncoder.encode(password));
        usuario.setRol("cliente");

        usuarioRepository.save(usuario);
        return "redirect:/";
    }
}
