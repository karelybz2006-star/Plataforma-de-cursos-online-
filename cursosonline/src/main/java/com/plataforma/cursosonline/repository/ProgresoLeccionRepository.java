package com.plataforma.cursosonline.repository;

import com.plataforma.cursosonline.entity.Leccion;
import com.plataforma.cursosonline.entity.ProgresoLeccion;
import com.plataforma.cursosonline.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgresoLeccionRepository extends JpaRepository<ProgresoLeccion, Long> {

    List<ProgresoLeccion> findByAlumno(Usuario alumno);

    List<ProgresoLeccion> findByAlumnoAndCompletadaTrue(Usuario alumno);

    boolean existsByAlumnoAndLeccion(Usuario alumno, Leccion leccion);
}