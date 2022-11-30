package com.proyecto.controller.Form;

import java.util.Optional;

import com.proyecto.forum.model.Curso;
import com.proyecto.forum.model.Topico;
import com.proyecto.forum.model.Usuario;

public class TopicoForm {

	private String titulo;
	private String mensaje;
	private Long IdUsuario;
	private String nombreCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Long getidUsuario() {
		return IdUsuario;
	}
	public Long setidUsuario(Long idusuario) {
		return this.IdUsuario = idusuario;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public Topico convertir(Optional<Usuario> usuario, Optional<Curso> curso) {
		return new Topico(titulo, mensaje, usuario, curso);

	}
	
	
}
