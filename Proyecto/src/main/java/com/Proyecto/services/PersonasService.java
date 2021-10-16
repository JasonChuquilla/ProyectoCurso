package com.Proyecto.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.models.Personas;
import com.Proyecto.repository.PersonasRepository;

@Service

public class PersonasService {
	@Autowired
	private PersonasRepository personasRepository;

	public PersonasService(PersonasRepository personasRepository) {
		super();
		this.personasRepository = personasRepository;
	}
	
	public List<Personas> obtenerTodosPersonas(){
		return (List<Personas>) personasRepository.findAll();
	}
	
	public Personas ingresarNuevoPersona(Personas objPersonas) {
		return personasRepository.save(objPersonas);		
	}
	
	public Personas actualizarPersona(Personas objPersonas) {
		return personasRepository.save(objPersonas);
	}
	
	public void eliminarPersonas (Personas objPersonas) {
		personasRepository.delete(objPersonas);
	}


}
