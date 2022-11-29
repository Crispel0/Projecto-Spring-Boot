package com.proyecto.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.controller.Form.TopicoForm;
import com.proyecto.controller.service.TopicoService;
import com.proyecto.dto.TopicoDTO;


@RequestMapping("/topicos")
@RestController //Create a ResponseBody into
public class TopicosController {
	//Abstraction of TopicoRepository for call the method listar//
	TopicoService topicoservice;
	/**
	 * Create a object of topicos, pass your valuer for parameters and return a {@link Arrays} "static" to {@link List}
	 */
	
	//@RequestMapping(value ="/topicos",method = RequestMethod.GET )
	@GetMapping
	List<TopicoDTO> listar(String nombreCurso){
		
		return topicoservice.listar(nombreCurso);
		
	}
	
	//@RequestMapping(value ="/topicos",method = RequestMethod.POST )
	@PostMapping 
	//here create a new Topico for make a difference between the TopicoDTO and this Topic//
	public void registrar (@RequestBody TopicoForm topicoForm) {
		topicoservice.registrar(topicoForm);
	}
}
