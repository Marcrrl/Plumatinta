package com.proyecto.plumatinta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyecto.plumatinta.service.UserService;
import com.proyecto.plumatinta.model.Usuario;

@Controller
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/auth/login")
    public String loginPage(Model model) {
        model.addAttribute("loginError", false);
        model.addAttribute("registerError", false);
        return "index";
    }

    @PostMapping("/auth/login")
    public String loginUser(Usuario usuario, Model model) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(), usuario.getContraseña());
            authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            model.addAttribute("user", auth.getPrincipal());

            return "redirect:/libros";
        } catch (Exception e) {
            model.addAttribute("loginError", true);
            return "index";
        }
    }

    @PostMapping("/auth/register")
public String registerUser(Usuario user, Model model) {
    if (userService.existsByEmail(user.getEmail())) {
        model.addAttribute("registerError", "El correo ya está en uso.");
        return "index";
    }

    user.setContraseña(passwordEncoder.encode(user.getContraseña()));

    userService.save(user);

    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            user.getEmail(), user.getContraseña());

    authenticationManager.authenticate(token);
    SecurityContextHolder.getContext().setAuthentication(token);

    return "index";
}

}
