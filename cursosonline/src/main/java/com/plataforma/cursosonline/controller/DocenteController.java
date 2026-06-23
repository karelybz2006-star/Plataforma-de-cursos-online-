package com.plataforma.cursosonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocenteController {

    @GetMapping("/panel-docente")
    public String panelDocente() {
        return "panel-docente";
    }

    @GetMapping("/crear-curso")
    public String crearCurso() {
        return "crear-curso";
    }
}
