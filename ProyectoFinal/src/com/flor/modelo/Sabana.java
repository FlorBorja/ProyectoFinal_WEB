package com.flor.modelo;

public class Sabana {

	private int clave_horario;
	private String clave_maestro;
	private String clave_materia;
	private String clave_carrera;
	private String materia;
	private String carrera;
	private String maestro;
	private String periodo;
	private String turno;
	private String nivel_estudio;
	private String grupo;
	private String campus;
	private int no_alumnos;
	private int semestre;
	private int creditos;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String salon;
	private int horas_t;
	private int horas_p;
	
	public Sabana(int clave_horario, String clave_maestro, String clave_materia, String clave_carrera, String materia,
			String carrera, String maestro, String periodo, String turno, String nivel_estudio, String grupo,
			String campus, int no_alumnos, int semestre, int creditos, String lunes, String martes, String miercoles,
			String jueves, String viernes, String salon, int horas_t, int horas_p) {
		super();
		this.clave_horario = clave_horario;
		this.clave_maestro = clave_maestro;
		this.clave_materia = clave_materia;
		this.clave_carrera = clave_carrera;
		this.materia = materia;
		this.carrera = carrera;
		this.maestro = maestro;
		this.periodo = periodo;
		this.turno = turno;
		this.nivel_estudio = nivel_estudio;
		this.grupo = grupo;
		this.campus = campus;
		this.no_alumnos = no_alumnos;
		this.semestre = semestre;
		this.creditos = creditos;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.salon = salon;
		this.horas_t = horas_t;
		this.horas_p = horas_p;
	}

	public int getClave_horario() {
		return clave_horario;
	}

	public void setClave_horario(int clave_horario) {
		this.clave_horario = clave_horario;
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

	public String getClave_carrera() {
		return clave_carrera;
	}

	public void setClave_carrera(String clave_carrera) {
		this.clave_carrera = clave_carrera;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getMaestro() {
		return maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getNivel_estudio() {
		return nivel_estudio;
	}

	public void setNivel_estudio(String nivel_estudio) {
		this.nivel_estudio = nivel_estudio;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public int getNo_alumnos() {
		return no_alumnos;
	}

	public void setNo_alumnos(int no_alumnos) {
		this.no_alumnos = no_alumnos;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
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
}
