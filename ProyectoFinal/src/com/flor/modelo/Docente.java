package com.flor.modelo;

public class Docente {
	private int id_maestro;
	private int id_carrera;
	private int id_usuario;
	private String nombre_c;
	
	public Docente(int id_carrera, int id_usuario) {
		super();
		this.id_carrera = id_carrera;
		this.id_usuario = id_usuario;
	}

	public Docente(int id_usuario, String nombre_c) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_c = nombre_c;
	}
	
	public int getId_maestro() {
		return id_maestro;
	}

	public void setId_maestro(int id_maestro) {
		this.id_maestro = id_maestro;
	}

	public int getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_c() {
		return nombre_c;
	}

	public void setNombre_c(String nombre_c) {
		this.nombre_c = nombre_c;
	}
}
