package com.flor.dao;

import com.flor.controlador.Conexion;
import com.flor.modelo.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {
	
	private Conexion con;
	private Connection connection;
	
	public DocenteDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public boolean asignarDocente (Docente docente) throws SQLException{
		boolean rowInserted=false;
		try {
		String sql = "INSERT INTO maestro (id_carrera, id_usuario) values (?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, docente.getId_carrera());
		statement.setInt(2, docente.getId_usuario());
		
		rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		}catch(Exception e){System.out.println(e);} 
		return rowInserted;
	} 
	
	//LISTAR DOCENTES CON CARRERA
	public List<Docente> listarDocentesCarrera(int id) throws SQLException {
		
		List<Docente> listaDocenteCarrera = new ArrayList<Docente>();
		String sql = "select id_usuario, CONCAT(usuario.prefijo, ' ', usuario.nombre) As nombre_c FROM usuario "
				+ "WHERE id_usuario IN (SELECT id_usuario FROM maestro WHERE id_carrera in "
				+ "(SELECT id_carrera from carrera WHERE id_carrera=?)) AND nombre != 'Administrador'";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resulSet = statement.executeQuery();
		
		while(resulSet.next()) {
			int id_usuario = resulSet.getInt("id_usuario");
			String nombre_c = resulSet.getString("nombre_c");
			Docente doce = new Docente(id_usuario, nombre_c);
			listaDocenteCarrera.add(doce);
		}
		con.desconectar();
		return listaDocenteCarrera;	
	}
	
	//LISTAR DOCENTES DISPONIBLES
	public List<Docente> listarDocentes() throws SQLException {
			
			List<Docente> listaDocente = new ArrayList<Docente>();
			String sql = "select id_usuario, CONCAT(usuario.prefijo, ' ', usuario.nombre) As nombre_c FROM usuario "
					+ "WHERE id_usuario NOT IN (SELECT id_usuario FROM maestro) AND nombre != 'Administrador'";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resulSet = statement.executeQuery();
			
			while(resulSet.next()) {
				int id_usuario = resulSet.getInt("id_usuario");
				String nombre_c = resulSet.getString("nombre_c");
				Docente docente = new Docente(id_usuario, nombre_c);
				listaDocente.add(docente);
			}
			con.desconectar();
			return listaDocente;	
	}
}
