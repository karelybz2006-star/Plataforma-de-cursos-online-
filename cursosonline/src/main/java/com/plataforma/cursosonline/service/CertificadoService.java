package com.plataforma.cursosonline.service;

import com.plataforma.cursosonline.entity.Certificado;
import com.plataforma.cursosonline.entity.Curso;
import com.plataforma.cursosonline.entity.Usuario;
import com.plataforma.cursosonline.repository.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CertificadoService {

    private final CertificadoRepository certificadoRepository;

    public CertificadoService(
            CertificadoRepository certificadoRepository) {

        this.certificadoRepository = certificadoRepository;
    }

    public Certificado generarCertificado(
            Usuario alumno,
            Curso curso) {

        Certificado certificado = new Certificado();

        certificado.setAlumno(alumno);
        certificado.setCurso(curso);
        certificado.setFechaEmision(LocalDate.now());

        String codigo =
                UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();

        certificado.setCodigoCertificado(codigo);

        return certificadoRepository.save(certificado);
    }

    public List<Certificado> obtenerTodos() {
        return certificadoRepository.findAll();
    }

    public void eliminar(Long id) {
        certificadoRepository.deleteById(id);
    }
}
