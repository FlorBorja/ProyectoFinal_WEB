package com.flor.modelo;

public class Usuario {
	private String clave_maestro;
	private String prefijo;
	private String nombre;
	private String correo;
	private int telefono;
	private String departamento;
	private String usuario;
	private String password;
	private String rol;
	private String nombre_c;

	public Usuario(String nombre, String correo, int telefono, String departamento,
			String usuario, String password, String rol) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.departamento = departamento;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}
	
	public Usuario(String clave_maestro, String prefijo ,String nombre, String correo, int telefono, String departamento) {
		super();
		this.clave_maestro = clave_maestro;
		this.prefijo = prefijo;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.departamento = departamento;
	}
	
	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}
	
	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getNombre_c() {
		return nombre_c;
	}

	public void setNombre_c(String nombre_c) {
		this.nombre_c = nombre_c;
	}

	public String getClave_maestro() {
		return clave_maestro;
	}

	public void setClave_maestro(String clave_maestro) {
		this.clave_maestro = clave_maestro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}