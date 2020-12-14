package com.flor.modelo;

public class Carrera {

	private int id_carrera;
	private String clave_carrera;
	private String carrera;
	private String	turno;
	
	public Carrera(int id_carrera, String clave_carrera, String carrera, String turno) {
		super();
		this.id_carrera = id_carrera;
		this.clave_carrera = clave_carrera;
		this.carrera = carrera;
		this.turno = turno;
	}

	public Carrera(int id_carrera, String carrera) {
		super();
		this.id_carrera = id_carrera;
		this.carrera = carrera;
	}
	
	public int getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getClave_carrera() {
		return clave_carrera;
	}

	public void setClave_carrera(String clave_carrera) {
		this.clave_carrera = clave_carrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
}
