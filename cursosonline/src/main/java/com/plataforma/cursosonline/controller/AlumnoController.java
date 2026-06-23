package com.plataforma.cursosonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {

    @GetMapping("/mis-cursos")
    public String misCursos() {
        return "mis-cursos";
    }

    @GetMapping("/certificados")
    public String certificados() {
        return "certificados";
    }
}