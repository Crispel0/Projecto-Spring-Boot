package com.proyecto.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.forum.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
