package com.proyecto.controller;

import java.net.URI;
import java.util.Arrays;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.controller.Form.TopicoForm;
import com.proyecto.controller.service.TopicoService;
import com.proyecto.dto.TopicoDTO;
import com.proyecto.forum.model.Topico;


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
	ResponseEntity<List<TopicoDTO>> listar(String nombreCurso){
		return ResponseEntity.ok(topicoservice.listar(nombreCurso));
	}
	
	//@RequestMapping(value ="/topicos",method = RequestMethod.POST )
	//here create a new Topico for make a difference between the TopicoDTO and this Topic//
	@PostMapping 
	
	
	public ResponseEntity<TopicoDTO> registrar (@RequestBody TopicoForm topicoForm, UriComponentsBuilder uriComponentbBuilder) {
		Topico topico = topicoservice.registrar(topicoForm);
		
		URI uri = uriComponentbBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); //Convert to a build for middle of the path//
		
		
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
}
