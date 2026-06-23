package com.plataforma.cursosonline.repository;

import com.plataforma.cursosonline.entity.Curso;
import com.plataforma.cursosonline.entity.Inscripcion;
import com.plataforma.cursosonline.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    boolean existsByAlumnoAndCurso(Usuario alumno, Curso curso);

    List<Inscripcion> findByAlumno(Usuario alumno);

    List<Inscripcion> findByCurso(Curso curso);
}
