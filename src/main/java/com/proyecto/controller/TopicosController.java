package com.proyecto.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.controller.service.TopicoService;
import com.proyecto.dto.TopicoDTO;



@RestController //Create a ResponseBody into
public class TopicosController {
	
	TopicoService topicoservice;
	/**
	 * Create a object of topicos, pass your valuer for parameters and return a {@link Arrays} "static" to {@link List}
	 */
	@RequestMapping("/topicos")
	List<TopicoDTO> listar (){
		
		return topicoservice.listar();
		
	}
}
