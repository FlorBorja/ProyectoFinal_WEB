package com.flor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flor.controlador.Conexion;
import com.flor.modelo.*;

public class ReporteDAO {

	private Conexion con;
	private Connection connection;
	
	public ReporteDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		//System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//MOTRAR TODOS LOS MAESTROS
	public List<Reporte> listarMaestro() throws SQLException {
	
		List<Reporte> listaMaestro = new ArrayList<Reporte>();
		String sql = "SELECT * FROM usuario WHERE clave_maestro != 'A00' and departamento='Sistemas/TICS'";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while(resulSet.next()) {
			String clave_maestro = resulSet.getString("clave_maestro");
			String nombre = resulSet.getString("nombre");
			Reporte reporte = new Reporte(clave_maestro, nombre);
			listaMaestro.add(reporte);
		}
		con.desconectar();
		return listaMaestro;	
	}
	
	//MOSTRAR EL REPORTE DE UN MAESTRO
	public List<Reporte> listarReporte(String clave_m) throws SQLException {
		
		List<Reporte> listaReporte = new ArrayList<Reporte>();
		String sql = "SELECT  sabana.maestro, sabana.clave_maestro, sabana.clave_materia, sabana.materia, "
				+ "sabana.grupo, sabana.salon, sabana.no_alumnos, sabana.clave_carrera, "
				+ "sabana.semestre, sabana.lunes, sabana.martes, sabana.miercoles,sabana.jueves, "
				+ "sabana.viernes, sabana.horas_t, sabana.horas_p ,sabana.creditos "
				+ "FROM sabana JOIN usuario ON sabana.clave_maestro = usuario.clave_maestro "
				+ "WHERE usuario.clave_maestro=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, clave_m);
		
		ResultSet resulSet = statement.executeQuery();
		while(resulSet.next()) {
			String maestro = resulSet.getString("maestro");
			String clave_maestro = resulSet.getString("clave_maestro");
			String clave_materia = resulSet.getString("clave_materia");
			String materia = resulSet.getString("materia");
			String grupo = resulSet.getString("grupo");
			String salon = resulSet.getString("salon");
			int no_alumnos = resulSet.getInt("no_alumnos");
			String clave_carrera = resulSet.getString("clave_carrera");
			int semestre = resulSet.getInt("semestre");
			String lunes = resulSet.getString("lunes");
			String martes = resulSet.getString("martes");
			String miercoles = resulSet.getString("miercoles");
			String jueves = resulSet.getString("jueves");
			String viernes = resulSet.getString("viernes");
			int horas_t = resulSet.getInt("horas_t");
			int horas_p = resulSet.getInt("horas_p");
			int creditos = resulSet.getInt("creditos");
			Reporte reporte = new Reporte(maestro, clave_maestro, clave_materia, materia, grupo, salon,
					no_alumnos, clave_carrera, semestre, lunes, martes, miercoles,
					jueves, viernes, horas_t, horas_p, creditos);
			listaReporte.add(reporte);
		}
		con.desconectar();	
		return listaReporte;
	}
	
	//MOSTRAR EL REPORTE DE UN MAESTRO POR USUARIO
	public List<Reporte> listarReporteP(String usuario) throws SQLException {
		
		List<Reporte> listaReporteP = new ArrayList<Reporte>();
		String sql = "SELECT  sabana.maestro, sabana.clave_maestro, sabana.clave_materia, sabana.materia, "
				+ "sabana.grupo, sabana.salon, sabana.no_alumnos, sabana.clave_carrera, "
				+ "sabana.semestre, sabana.lunes, sabana.martes, sabana.miercoles,sabana.jueves, "
				+ "sabana.viernes, sabana.horas_t, sabana.horas_p ,sabana.creditos "
				+ "FROM sabana JOIN usuario ON sabana.clave_maestro = usuario.clave_maestro "
				+ "WHERE usuario.usuario=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario);
		
		ResultSet resulSet = statement.executeQuery();
		while(resulSet.next()) {
			String maestro = resulSet.getString("maestro");
			String clave_maestro = resulSet.getString("clave_maestro");
			String clave_materia = resulSet.getString("clave_materia");
			String materia = resulSet.getString("materia");
			String grupo = resulSet.getString("grupo");
			String salon = resulSet.getString("salon");
			int no_alumnos = resulSet.getInt("no_alumnos");
			String clave_carrera = resulSet.getString("clave_carrera");
			int semestre = resulSet.getInt("semestre");
			String lunes = resulSet.getString("lunes");
			String martes = resulSet.getString("martes");
			String miercoles = resulSet.getString("miercoles");
			String jueves = resulSet.getString("jueves");
			String viernes = resulSet.getString("viernes");
			int horas_t = resulSet.getInt("horas_t");
			int horas_p = resulSet.getInt("horas_p");
			int creditos = resulSet.getInt("creditos");
			Reporte reporte = new Reporte(maestro, clave_maestro, clave_materia, materia, grupo, salon,
					no_alumnos, clave_carrera, semestre, lunes, martes, miercoles,
					jueves, viernes, horas_t, horas_p, creditos);
			listaReporteP.add(reporte);
		}
		con.desconectar();	
		return listaReporteP;
	}
}