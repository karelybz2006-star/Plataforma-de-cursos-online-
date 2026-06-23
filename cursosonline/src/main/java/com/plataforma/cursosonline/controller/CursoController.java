package com.plataforma.cursosonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CursoController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/cursos")
    public String cursos() {
        return "cursos";
    }
}