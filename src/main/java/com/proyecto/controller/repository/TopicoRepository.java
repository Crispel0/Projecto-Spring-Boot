package com.proyecto.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.forum.model.Topico;

//Receive two parameters the class that desire implement the differents methods and the ID of this class//
public interface TopicoRepository extends JpaRepository<Topico, Long>{

}
