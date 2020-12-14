package com.flor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flor.controlador.Conexion;
import com.flor.modelo.Materia;

public class MateriaDAO {
	
	private Conexion con;
	private Connection connection;
	
	public MateriaDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//INSERTAR MATERIA
	public boolean insertarMateria (Materia materia) throws SQLException{
		boolean rowInserted=false;
		try {
		String sql = "INSERT INTO materias (clave_horario, clave_materia, materia, semestre, "
				+ "carrera, periodo, maestro, turno, campus, grupo, no_alumnos, creditos, "
				+ "horas_t, horas_p, lunes, martes, miercoles, jueves, viernes, salon) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, materia.getClave_horario());
		statement.setString(2, materia.getClave_materia());
		statement.setString(3, materia.getMateria());
		statement.setInt(4, materia.getSemestre());
		statement.setString(5, materia.getCarrera());
		statement.setString(6, materia.getPeriodo());
		statement.setString(7, materia.getMaestro());
		statement.setString(8, materia.getTurno());
		statement.setString(9, materia.getCampus());
		statement.setString(10, materia.getGrupo());
		statement.setInt(11, materia.getNo_alumnos());
		statement.setInt(12, materia.getCreditos());
		statement.setInt(13, materia.getHoras_t());
		statement.setInt(14, materia.getHoras_p());
		statement.setString(15, materia.getLunes());
		statement.setString(16, materia.getMartes());
		statement.setString(17, materia.getMiercoles());
		statement.setString(18, materia.getJueves());
		statement.setString(19, materia.getViernes());
		statement.setString(20, materia.getSalon());
		
		rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		}catch(Exception e){System.out.println(e);} 
		return rowInserted;
	} 
	
	public List<Materia> listarMateria() throws SQLException {
		
		List<Materia> listaMateria = new ArrayList<Materia>();
		String sql = "SELECT * FROM materias";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while(resulSet.next()) {
			int clave_horario = resulSet.getInt("clave_horario");
			String clave_materia = resulSet.getString("clave_materia");
			String materia = resulSet.getString("materia");
			int semestre = resulSet.getInt("semestre");
			String carrera = resulSet.getString("carrera");
			String periodo = resulSet.getString("periodo");
			String maestro = resulSet.getString("maestro");
			String turno = resulSet.getString("turno");
			String campus = resulSet.getString("campus");
			String grupo = resulSet.getString("grupo");
			int no_alumnos = resulSet.getInt("no_alumnos");
			int creditos = resulSet.getInt("creditos");
			int horas_t = resulSet.getInt("horas_t");
			int horas_p = resulSet.getInt("horas_p");
			String lunes = resulSet.getString("lunes");
			String martes = resulSet.getString("martes");
			String miercoles = resulSet.getString("miercoles");
			String jueves = resulSet.getString("jueves");
			String viernes = resulSet.getString("viernes");
			String salon = resulSet.getString("salon");
			
			Materia materias = new Materia(clave_horario, clave_materia, materia, semestre, carrera,
					periodo, maestro, turno, campus, grupo, no_alumnos,  creditos, horas_t, horas_p,
					lunes, martes, miercoles, jueves, viernes, salon);
			listaMateria.add(materias);
		}
		con.desconectar();
		return listaMateria;	
	}
	
	//OBTENER POR ID
		public Materia obtenerID(int clave_horario) throws SQLException {
			
			Materia materia = null;
			try {
			String sql = "SELECT * FROM materias WHERE clave_horario= ?";
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
		}
	
	//ACTUALIZAR
		public boolean actualizarMateria(Materia materia) throws SQLException {
			
			boolean rowActualizar = false;
			try {
			String sql = "UPDATE materias SET clave_materia=?, materia=?, semestre=?, "  
									+ "carrera=?, periodo=?, maestro=?, turno=?, campus=?, grupo=?, no_alumnos=?, creditos=?, " 
									+ "horas_t=?, horas_p=?, lunes=?, martes=?, miercoles=?, jueves=?, viernes=?, salon=? WHERE clave_horario= ?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, materia.getClave_materia());
			statement.setString(2, materia.getMateria());
			statement.setInt(3, materia.getSemestre());
			statement.setString(4, materia.getCarrera());
			statement.setString(5, materia.getPeriodo());
			statement.setString(6, materia.getMaestro());
			statement.setString(7, materia.getTurno());
			statement.setString(8, materia.getCampus());
			statement.setString(9, materia.getGrupo());
			statement.setInt(10, materia.getNo_alumnos());
			statement.setInt(11, materia.getCreditos());
			statement.setInt(12, materia.getHoras_t());
			statement.setInt(13, materia.getHoras_p());
			statement.setString(14, materia.getLunes());
			statement.setString(15, materia.getMartes());
			statement.setString(16, materia.getMiercoles());
			statement.setString(17, materia.getJueves());
			statement.setString(18, materia.getViernes());
			statement.setString(19, materia.getSalon());
			statement.setInt(20, materia.getClave_horario());
			
			rowActualizar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			}catch(Exception e){System.out.println(e);} 
			return rowActualizar;
		}
		
		//ELIMINAR
		public boolean eliminarMateria(Materia materia) throws SQLException {
			
			boolean rowEliminar = false;
			try {
			String sql = "DELETE FROM materias WHERE clave_horario=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, materia.getClave_horario());
			
			rowEliminar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			}catch(Exception e){System.out.println(e);} 
			return rowEliminar;
		}
}
