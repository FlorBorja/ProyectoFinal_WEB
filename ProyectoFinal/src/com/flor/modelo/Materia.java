package com.flor.modelo;

public class Materia {
	
	private int clave_horario;
	private String clave_materia;
	private String materia;
	private int semestre;
	private String carrera;
	private String periodo;
	private String maestro;
	private String turno;
	private String campus;
	private String grupo;
	private int no_alumnos;
	private int creditos;
	private int horas_t;
	private int horas_p;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String salon;
	
	public Materia(int clave_horario, String clave_materia, String materia, int semestre, String carrera,
			String periodo, String maestro, String turno, String campus, String grupo, int no_alumnos, int creditos,
			int horas_t, int horas_p, String lunes, String martes, String miercoles, String jueves, String viernes,
			String salon) {
		super();
		this.clave_horario = clave_horario;
		this.clave_materia = clave_materia;
		this.materia = materia;
		this.semestre = semestre;
		this.carrera = carrera;
		this.periodo = periodo;
		this.maestro = maestro;
		this.turno = turno;
		this.campus = campus;
		this.grupo = grupo;
		this.no_alumnos = no_alumnos;
		this.creditos = creditos;
		this.horas_t = horas_t;
		this.horas_p = horas_p;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.salon = salon;
	}
	
	public int getClave_horario() {
		return clave_horario;
	}

	public void setClave_horario(int clave_horario) {
		this.clave_horario = clave_horario;
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

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMaestro() {
		return maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getNo_alumnos() {
		return no_alumnos;
	}

	public void setNo_alumnos(int no_alumnos) {
		this.no_alumnos = no_alumnos;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
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

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}
}
