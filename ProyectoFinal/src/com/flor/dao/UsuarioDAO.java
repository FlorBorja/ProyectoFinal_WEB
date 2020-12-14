package com.flor.dao;

import com.flor.controlador.Conexion;
import com.flor.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	
	private Conexion con;
	private Connection connection;
	
	public UsuarioDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//INSERTAR USUARIO
	public boolean insertarUsuario (Usuario usuario) throws SQLException{
		boolean rowInserted=false;
		try {
		String sql = "INSERT INTO usuario (clave_maestro, nombre, correo, telefono, "
				+ "departamento, usuario, password, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "");
		statement.setString(2, usuario.getNombre());
		statement.setString(3, usuario.getCorreo());
		statement.setInt(4, usuario.getTelefono());
		statement.setString(5, usuario.getDepartamento());
		statement.setString(6, usuario.getUsuario());
		statement.setString(7, usuario.getPassword());
		statement.setString(8, usuario.getRol());
		
		rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		}catch(Exception e){System.out.println(e);} 
		return rowInserted;
	} 
	
	//VALIDAR USUARIO
	public String validar(Usuario usuario)  throws SQLException{  
		 
		String rol = "";  
		try{  
		con.conectar();
		connection = con.getJdbcConnection();
		      
		PreparedStatement statement = connection.prepareStatement(  
		"SELECT rol FROM usuario where usuario=? and password=?"); 
		statement.setString(1,usuario.getUsuario());  
		statement.setString(2,usuario.getPassword());  
		      
		ResultSet resulSet = statement.executeQuery();  
		
		while(resulSet.next()) {
			rol = resulSet.getString(1);
		} 
		
		//System.out.println("De la bd: " + usuario.getUsuario() + " " + usuario.getPassword());
		connection.close();          
		}catch(Exception e){System.out.println(e);}  
		return rol;  
	}
	
	public List<Usuario> perfil(String user) throws SQLException {
		
		List<Usuario> datos = new ArrayList<Usuario>();
		String sql = "SELECT clave_maestro, prefijo, nombre, correo, telefono, departamento from usuario where usuario=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user);
		ResultSet resulSet = statement.executeQuery();
		
		while(resulSet.next()) {
			String clave_maestro = resulSet.getString("clave_maestro");
			String prefijo = resulSet.getString("prefijo");
			String nombre = resulSet.getString("nombre");
			String correo = resulSet.getString("correo");
			int telefono = resulSet.getInt("telefono");
			String departamento = resulSet.getString("departamento");
			
			Usuario usuario = new Usuario(clave_maestro, prefijo, nombre, correo, telefono, departamento);
			datos.add(usuario);
		}
		con.desconectar();
		return datos;	
	}
}
