package com.zetcode;

import java.util.*;

public class Usuario {
	private String user;
	private String nombre;
	private String apellidos;
	private String DNI;
	private String email;
	private Date fechaNacimiento;
	private String clave;

	public Usuario(String user, String nombre, String apellidos, String dNI, String email, Date fechaNacimiento,
			String clave) {
		this.user = user;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dNI;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellidos;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
