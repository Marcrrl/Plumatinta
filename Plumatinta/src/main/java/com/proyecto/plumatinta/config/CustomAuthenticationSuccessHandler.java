package com.proyecto.plumatinta.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, 
                                        jakarta.servlet.http.HttpServletResponse response, 
                                        Authentication authentication) throws IOException, ServletException {
        response.sendRedirect("/");
    }
}
