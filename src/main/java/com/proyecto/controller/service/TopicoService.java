package com.proyecto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.controller.repository.TopicoRepository;
import com.proyecto.dto.TopicoDTO;
import com.proyecto.forum.model.Topico;

@Service
public class TopicoService {
	
	@Autowired //indique Spring that is a dependencie//
	TopicoRepository topicorepository;

	public List<TopicoDTO> listar() {
			List<Topico> resultado = topicorepository.findAll();
		return TopicoDTO.convertir(resultado);
	} 
}
