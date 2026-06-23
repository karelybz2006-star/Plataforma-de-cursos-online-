package com.plataforma.cursosonline.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "progreso_lecciones")
public class ProgresoLeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Usuario alumno;

    @ManyToOne
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    @Column(nullable = false)
    private boolean completada;

    public ProgresoLeccion() {
    }

    public ProgresoLeccion(Long id, Usuario alumno, Leccion leccion, boolean completada) {
        this.id = id;
        this.alumno = alumno;
        this.leccion = leccion;
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public Leccion getLeccion() {
        return leccion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}