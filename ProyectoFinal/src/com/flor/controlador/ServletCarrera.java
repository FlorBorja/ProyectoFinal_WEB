package com.flor.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flor.dao.CarreraDAO;
import com.flor.modelo.Carrera;

/**
 * Servlet implementation class ServletMateria
 */
@WebServlet("/ServletCarrera")
public class ServletCarrera extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarreraDAO carreraDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			carreraDAO = new CarreraDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCarrera() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//System.out.println("Hola Servlet Usuario..");
		String action = req.getParameter("action");
		//System.out.println("Accion del servlet Usuario: "+action);
		try {
			switch (action) {
			case "registrarCarrera":
				registrarCarrera(req, res);
				break;
			case "listarCarrera":
				listarCarrera(req, res);
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Usuario..");
		System.out.print(getServletContext().getInitParameter("jdbcURL")+"  ");
		doGet(req, res);
	}
	
	private void registrarCarrera(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		Carrera carrera = new Carrera(0, req.getParameter("clave_carrera"), req.getParameter("carrera"), req.getParameter("turno"));
		carreraDAO.insertarCarrera(carrera);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/menu_administrador.jsp");
	}
	
	private void listarCarrera(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{	
		List<Carrera> listaCarrera= carreraDAO.listarCarrera();
		req.setAttribute("lista", listaCarrera);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/menu_administrador.jsp");
	}
	
}
