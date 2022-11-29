package com.proyecto.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.forum.model.Topico;

//Receive two parameters the class that desire implement the differents methods and the ID of this class//
public interface TopicoRepository extends JpaRepository<Topico, Long>{

	//Method own where search from the interface JpaRepository by the camp of a relation {name of relation Nombre: camp of the relation Curso}
	List<Topico> findByCursoNombre(String nombreCurso);
}
