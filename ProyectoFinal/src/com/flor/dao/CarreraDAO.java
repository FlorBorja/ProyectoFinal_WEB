package com.flor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flor.controlador.Conexion;
import com.flor.modelo.Carrera;

public class CarreraDAO {
	
	private Conexion con;
	private Connection connection;
	
	public CarreraDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//INSERTAR CARRERA
	public boolean insertarCarrera (Carrera carrera) throws SQLException{
		boolean rowInserted=false;
		try {
		String sql = "INSERT INTO carrera (id_carrera, clave_carrera, carrera, turno) "
				+ "VALUES (?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, carrera.getId_carrera());
		statement.setString(2, carrera.getClave_carrera());
		statement.setString(3, carrera.getCarrera());
		statement.setString(4, carrera.getTurno());
		
		rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		}catch(Exception e){System.out.println(e);} 
		return rowInserted;
	} 
	
	//LISTAR CARRERAS
	public List<Carrera> listarCarrera() throws SQLException {
		
		List<Carrera> listaCarrera = new ArrayList<Carrera>();
		String sql = "SELECT * FROM carrera";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while(resulSet.next()) {
			int id_carrera = resulSet.getInt("id_carrera");
			String clave_carrera = resulSet.getString("clave_carrera");
			String carrera = resulSet.getString("carrera");
			String turno = resulSet.getString("turno");
			
			Carrera carreras = new Carrera(id_carrera, clave_carrera, carrera, turno);
			listaCarrera.add(carreras);
		}
		con.desconectar();
		return listaCarrera;	
	}
	
	public List<Carrera> carrera_jefe() throws SQLException {
		
		List<Carrera> carrera = new ArrayList<Carrera>();
		String sql = "SELECT * from carrera INNER JOIN maestro on maestro.id_carrera = carrera.id_carrera WHERE maestro.id_usuario=2";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resulSet = statement.executeQuery();
		
		while(resulSet.next()) {
			int id_carrera = resulSet.getInt("id_carrera");
			String ca = resulSet.getString("carrera");
			Carrera carreras = new Carrera(id_carrera, ca);
			carrera.add(carreras);
		}
		con.desconectar();
		return carrera;	
	}
	
	/*OBTENER POR ID
		public Carrera obtenerID(int id) throws SQLException {
			
			Carrera carrera = null;
			try {
			String sql = "SELECT * FROM carrera WHERE id= ?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, clave_horario);
			
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				materia = new Materia(res.getInt("clave_horario"),
				res.getString("clave_materia"), res.getString("materia"), res.getInt("semestre"),
				res.getString("carrera"), res.getString("periodo"), res.getString("maestro"),
				res.getString("turno"), res.getString("campus"), res.getString("grupo"),
				res.getInt("no_alumnos"), res.getInt("creditos"), res.getInt("horas_t"),
				res.getInt("horas_p"), res.getString("lunes"), res.getString("martes"),
				res.getString("miercoles"), res.getString("jueves"), res.getString("viernes"),
				res.getString("salon"));
			}
			res.close();
			con.desconectar();
			}catch(Exception e){System.out.println(e);} 
			return materia;
		}*/
}
