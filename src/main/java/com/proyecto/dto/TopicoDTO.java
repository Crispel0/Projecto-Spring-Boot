package com.proyecto.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.forum.model.Topico;

public class TopicoDTO {

	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	
	public TopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensaje = topico.getMensaje();
		this.fechaCreacion = topico.getFechaCreacion();
	}
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public static List<TopicoDTO> convertir(List<Topico> topico) {
		/*Toma a topico convierte a stream remplazando el for este convierte en map 
		creando una instancia de TopicoDTO y lo colecciona por una lista y return como un TopicoDTO
		*/
		return topico.stream().map(TopicoDTO::new).collect(Collectors.toList());
	}
	
	
}
