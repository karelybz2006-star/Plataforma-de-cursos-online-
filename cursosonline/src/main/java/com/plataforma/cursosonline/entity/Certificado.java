package com.plataforma.cursosonline.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Usuario alumno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(nullable = false, unique = true)
    private String codigoCertificado;

    public Certificado() {
    }

    public Certificado(Long id, Usuario alumno, Curso curso,
                        LocalDate fechaEmision, String codigoCertificado) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
        this.fechaEmision = fechaEmision;
        this.codigoCertificado = codigoCertificado;
    }

    public Long getId() {
        return id;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public String getCodigoCertificado() {
        return codigoCertificado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setCodigoCertificado(String codigoCertificado) {
        this.codigoCertificado = codigoCertificado;
    }
}
