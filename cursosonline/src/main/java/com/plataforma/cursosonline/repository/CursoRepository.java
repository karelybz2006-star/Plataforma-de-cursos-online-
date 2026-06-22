package com.plataforma.cursosonline.repository;

import com.plataforma.cursosonline.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}

