package com.proyecto.forum.model;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING) //Guarda el valor del array inicializado en 0 en una String para mostrarlo en el endpoint//
	private StatusTopico status = StatusTopico.SIN_RESPUESTA;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "topico") //parametro para hacer una relacion entre clase Topico y Atributo De Clase Respuesta//
	private List<Respuesta> respuestas = new ArrayList<>();

	public Topico () {} //Constuctor default para que el la BBDD acepte su entrada y no lanze errors//

	public Topico(String titulo, String mensaje, Optional<Usuario> usuario, Optional<Curso> curso) {
		this.titulo = titulo; this.mensaje = mensaje;
		
		usuario.ifPresent(u -> this.autor = u); //si el usuario esta presente {existe} entonces asignale a autor con la variable u
		curso.ifPresent(c -> this.curso = c); //si el usuario esta presente {existe} entonces asignale c curso con la variable c
		
	}
	
	public Topico() {}; //this constructor is for that when the base connect//

	public Topico(String titulo, String mensaje, Optional<Usuario> usuario, Optional<Curso> curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		 //if the autor is present so assign to the atributte autor//
		usuario.ifPresent(a->this.autor = a);
		curso.ifPresent(c ->this.curso = c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}
