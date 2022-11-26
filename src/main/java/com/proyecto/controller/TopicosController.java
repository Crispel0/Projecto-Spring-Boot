package com.proyecto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.dto.TopicoDTO;
import com.proyecto.forum.model.Curso;
import com.proyecto.forum.model.Topico;


@RestController //Create a ResponseBody into
public class TopicosController {
	
	
	/**
	 * Create a object of topicos, pass your valuer for parameters and return a {@link Arrays} "static" to {@link List}
	 */
	@RequestMapping("/topicos")
	List<TopicoDTO> listar (){

		
		Topico topico = new Topico("Titulo Topico", "Mensaje Topico", new Curso("Linux", "DevOps"));
		Topico topico2 = new Topico("Titulo Topico", "Mensaje Topico", new Curso("C#", "Programacion"));
		Topico topico3 = new Topico("Titulo Topico", "Mensaje topico", new Curso("JS", "Lenguajes Programacion"));
		
		return TopicoDTO.convertir(Arrays.asList(topico,topico2, topico3));
		
	}
}
