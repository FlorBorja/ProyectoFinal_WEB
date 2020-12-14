package com.flor.modelo;

public class Reporte {
	private String maestro;
	private String clave_maestro;
	private String clave_materia;
	private String nombre;
	private String materia;
	private String grupo;
	private String salon;
	private int no_alumnos;
	private String clave_carrera;
	private int semestre;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private int horas_t;
	private int horas_p;
	private int creditos;
	
	public Reporte(String maestro, String clave_maestro, String clave_materia, String materia, String grupo, String salon,
			int no_alumnos, String clave_carrera, int semestre, String lunes, String martes, String miercoles,
			String jueves, String viernes, int horas_t, int horas_p, int creditos) {
		super();
		this.maestro = maestro;
		this.clave_maestro = clave_maestro;
		this.clave_materia = clave_materia;
		this.materia = materia;
		this.grupo = grupo;
		this.salon = salon;
		this.no_alumnos = no_alumnos;
		this.clave_carrera = clave_carrera;
		this.semestre = semestre;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.horas_t = horas_t;
		this.horas_p = horas_p;
		this.creditos = creditos;
	}
	
	public Reporte(String clave_maestro, String nombre) {
		this.clave_maestro = clave_maestro;
		this.setNombre(nombre);
	}

	public String getClave_maestro() {
		return clave_maestro;
	}

	public void setClave_maestro(String clave_maestro) {
		this.clave_maestro = clave_maestro;
	}

	public String getClave_materia() {
		return clave_materia;
	}

	public void setClave_materia(String clave_materia) {
		this.clave_materia = clave_materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public int getNo_alumnos() {
		return no_alumnos;
	}

	public void setNo_alumnos(int no_alumnos) {
		this.no_alumnos = no_alumnos;
	}

	public String getClave_carrera() {
		return clave_carrera;
	}

	public void setClave_carrera(String clave_carrera) {
		this.clave_carrera = clave_carrera;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getLunes() {
		return lunes;
	}

	public void setLunes(String lunes) {
		this.lunes = lunes;
	}

	public String getMartes() {
		return martes;
	}

	public void setMartes(String martes) {
		this.martes = martes;
	}

	public String getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}

	public String getJueves() {
		return jueves;
	}

	public void setJueves(String jueves) {
		this.jueves = jueves;
	}

	public String getViernes() {
		return viernes;
	}

	public void setViernes(String viernes) {
		this.viernes = viernes;
	}

	public int getHoras_t() {
		return horas_t;
	}

	public void setHoras_t(int horas_t) {
		this.horas_t = horas_t;
	}

	public int getHoras_p() {
		return horas_p;
	}

	public void setHoras_p(int horas_p) {
		this.horas_p = horas_p;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMaestro() {
		return maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}
}
