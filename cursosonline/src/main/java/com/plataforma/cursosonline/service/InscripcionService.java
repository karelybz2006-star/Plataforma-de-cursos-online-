package com.plataforma.cursosonline.service;

import com.plataforma.cursosonline.entity.Curso;
import com.plataforma.cursosonline.entity.Inscripcion;
import com.plataforma.cursosonline.entity.Usuario;
import com.plataforma.cursosonline.repository.CursoRepository;
import com.plataforma.cursosonline.repository.InscripcionRepository;
import com.plataforma.cursosonline.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public InscripcionService(
            InscripcionRepository inscripcionRepository,
            UsuarioRepository usuarioRepository,
            CursoRepository cursoRepository) {

        this.inscripcionRepository = inscripcionRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Inscripcion> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Optional<Inscripcion> obtenerPorId(Long id) {
        return inscripcionRepository.findById(id);
    }

    public Inscripcion inscribirAlumno(Long alumnoId, Long cursoId) {

        Usuario alumno = usuarioRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (inscripcionRepository.existsByAlumnoAndCurso(alumno, curso)) {
            throw new RuntimeException("El alumno ya está inscrito en este curso");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(LocalDate.now());

        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> obtenerCursosDeAlumno(Usuario alumno) {
        return inscripcionRepository.findByAlumno(alumno);
    }

    public List<Inscripcion> obtenerAlumnosDeCurso(Curso curso) {
        return inscripcionRepository.findByCurso(curso);
    }

    public void eliminarInscripcion(Long id) {

        if (!inscripcionRepository.existsById(id)) {
            throw new RuntimeException("La inscripción no existe");
        }

        inscripcionRepository.deleteById(id);
    }
}