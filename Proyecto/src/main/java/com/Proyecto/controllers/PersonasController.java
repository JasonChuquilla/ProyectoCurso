package com.Proyecto.controllers;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.models.Personas;
import com.Proyecto.services.PersonasService;
import com.Proyecto.Utils.ModelUtil;

@RestController
@RequestMapping("/personas")
public class PersonasController {
	private static final Logger logger = LoggerFactory.getLogger(PersonasController.class);
	private PersonasService personasService;

	public PersonasController(PersonasService personasService) {
		super();
		this.personasService = personasService;
	}
	
	@GetMapping(produces = "application/json")
	public List<Personas> obtenerPersonas() throws Exception{
		try {
			return personasService.obtenerTodosPersonas();
		}catch (Exception e) {
			logger.info("Error en el consumo del servicio obtener Personas. " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	@PostMapping(produces = "application/json")
	public Personas guardarPersona(@RequestBody @Validated Personas objPersonas ) throws Exception {
		try {
			
			return personasService.ingresarNuevoPersona(objPersonas);
		}catch (Exception e) {
			logger.info("Error en el consumo del servicio guardar Persona. " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	private void validacionDatosPersona(Personas objPersona) throws Exception {
		ModelUtil.validarCedula(objPersona.getCedula());
		ModelUtil.ValidarMail(objPersona.getEmail());
		if (!ModelUtil.validacionSoloLetras(objPersona.getApellidos()))
			throw new Exception("Solo Letras");
		if (!ModelUtil.validacionSoloLetras(objPersona.getNombres()))
			throw new Exception("Solo Letras");
		if (ModelUtil.verificarCadenaVacio(objPersona.getFechaNacimiento()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.verificarCadenaVacio(objPersona.getCedula()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.verificarCadenaVacio(objPersona.getApellidos()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.verificarCadenaVacio(objPersona.getNombres()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.verificarCadenaVacio(objPersona.getEmail()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.verificarCadenaVacio(objPersona.getDomicilio()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.verificarCadenaVacio(objPersona.getProvincia()))
			throw new Exception("Llenar los datos");
		if (ModelUtil.validacionSoloNumeros(objPersona.getTelefono()))
			throw new Exception("Solo Numeros");

	}
	
	@PutMapping(produces = "application/json")
	public Personas actualizarPersonas(@RequestBody @Validated Personas objPersonas) throws Exception {
		try {
			return personasService.actualizarPersona(objPersonas);
		}catch (Exception e) {
			logger.info("Error en el consumo del servicio actualizar Persona. " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public boolean eliminarPersonas (@RequestBody @Validated Personas objPersonas) throws Exception {
		try {
			personasService.eliminarPersonas(objPersonas);
			return true;
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio guardar Rol. " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
}
