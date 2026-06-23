package com.plataforma.cursosonline.service;

import com.plataforma.cursosonline.entity.Leccion;
import com.plataforma.cursosonline.entity.ProgresoLeccion;
import com.plataforma.cursosonline.entity.Usuario;
import com.plataforma.cursosonline.repository.ProgresoLeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoLeccionService {

    private final ProgresoLeccionRepository progresoRepository;

    public ProgresoLeccionService(
            ProgresoLeccionRepository progresoRepository) {

        this.progresoRepository = progresoRepository;
    }

    public ProgresoLeccion marcarLeccionCompletada(
            Usuario alumno,
            Leccion leccion) {

        if (progresoRepository.existsByAlumnoAndLeccion(alumno, leccion)) {
            throw new RuntimeException(
                    "La lección ya fue completada por este alumno");
        }

        ProgresoLeccion progreso = new ProgresoLeccion();

        progreso.setAlumno(alumno);
        progreso.setLeccion(leccion);
        progreso.setCompletada(true);

        return progresoRepository.save(progreso);
    }

    public List<ProgresoLeccion> obtenerProgresoAlumno(
            Usuario alumno) {

        return progresoRepository.findByAlumno(alumno);
    }

    public long obtenerLeccionesCompletadas(
            Usuario alumno) {

        return progresoRepository
                .findByAlumnoAndCompletadaTrue(alumno)
                .size();
    }
}
