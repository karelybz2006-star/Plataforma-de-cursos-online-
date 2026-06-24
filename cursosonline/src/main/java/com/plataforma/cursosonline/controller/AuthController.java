package com.plataforma.cursosonline.controller;

import com.plataforma.cursosonline.entity.Rol;
import com.plataforma.cursosonline.entity.Usuario;
import com.plataforma.cursosonline.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String password,
            @RequestParam Rol rol) {

        
        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setPassword(password);
        usuario.setRol(rol);

        usuarioService.guardar(usuario);

        return "redirect:/login";
    }
}