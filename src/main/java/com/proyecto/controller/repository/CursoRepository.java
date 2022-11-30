package com.proyecto.controller.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Optional<Curso> findByNombre(String nombreCurso);
}
