package com.Proyecto.models;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="Personas")
@NamedQuery(name="Personas.findAll", query="SELECT u FROM Personas u")
public class Personas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula")
	private String cedula;


	private String apellidos;

	private String nombres;

	private String email;
	
	private String provincia;

	private String canton;

	private String domicilio;
	
	private String fechaNacimiento;

	private String telefono;

	
	public Personas() {
	}

	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getCanton() {
		return canton;
	}


	public void setCanton(String canton) {
		this.canton = canton;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Personas [cedula=" + cedula + ", apellidos=" + apellidos + ", nombres=" + nombres + ", email=" + email
				+ ", provincia=" + provincia + ", canton=" + canton + ", domicilio=" + domicilio + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + "]";
	}


	
}