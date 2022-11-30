package com.proyecto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.proyecto.controller.Form.TopicoForm;
import com.proyecto.controller.repository.CursoRepository;
import com.proyecto.controller.repository.TopicoRepository;
import com.proyecto.controller.repository.UsuarioRepository;
import com.proyecto.dto.TopicoDTO;
import com.proyecto.forum.model.Curso;
import com.proyecto.forum.model.Topico;
import com.proyecto.forum.model.Usuario;


@Service
public class TopicoService {
	
	@Autowired //indique Spring that is a dependencie//
	private TopicoRepository topicoRepository;
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<TopicoDTO> listar(String nombreCurso) {
		List<Topico> resultado;
		if(nombreCurso == null) {
			resultado = topicoRepository.findAll();}
		else { //Search of nameofcourse for your titule {is a type of abstraction where call the relation for your camp}//
			resultado = topicoRepository.findByCurso_Nombre(nombreCurso);
		}
		return TopicoDTO.convertir(resultado);
	}
	
	//the JpaRepository find a id from the topicoForm and save this date in a Optional or not of Usuario//
	public Topico registrar(TopicoForm topicoForm) { //search of dates specify with the get of each class//
		Optional<Usuario> usuario = usuariorepository.findById(topicoForm.getidUsuario());
		Optional <Curso> curso = cursoRepository.findByNombre(topicoForm.getNombreCurso());
		
		Topico topico = topicoForm.convertir(usuario,curso);
		
		return topicoRepository.save(topico);

	} 
}
