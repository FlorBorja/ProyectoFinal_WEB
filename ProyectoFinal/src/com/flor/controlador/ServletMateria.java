package com.flor.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flor.dao.MateriaDAO;
import com.flor.modelo.Materia;

/**
 * Servlet implementation class ServletMateria
 */
@WebServlet("/ServletMateria")
public class ServletMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MateriaDAO materiaDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			materiaDAO = new MateriaDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMateria() {}

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
			case "registrarMateria":
				registrarMateria(req, res);
				break;
			case "showEditar":
				showEditar(req, res);
				break;	
			case "editar":
				editar(req, res);
				break;	
			case "eliminar":
				eliminar(req, res);
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
	
	private void registrarMateria(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		Materia materia = new Materia(Integer.parseInt(req.getParameter("clave_horario")), req.getParameter("clave_materia"),
				req.getParameter("materia"), Integer.parseInt(req.getParameter("semestre")), req.getParameter("carrera"), 
				req.getParameter("periodo"), req.getParameter("maestro"), req.getParameter("turno"), req.getParameter("campus"),
				req.getParameter("grupo"), Integer.parseInt(req.getParameter("no_alumnos")), Integer.parseInt(req.getParameter("creditos")), 
				Integer.parseInt(req.getParameter("horas_t")), Integer.parseInt(req.getParameter("horas_p")), req.getParameter("lunes"),
				req.getParameter("martes"), req.getParameter("miercoles"), req.getParameter("jueves"), req.getParameter("viernes"), 
				req.getParameter("salon"));
		materiaDAO.insertarMateria(materia);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/listar_materias.jsp");
	}
	
	private void showEditar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		try {
		Materia materia = materiaDAO.obtenerID(Integer.parseInt(req.getParameter("clave_horario")));
		req.setAttribute("materias", materia);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/editar_materia.jsp");
		}catch(Exception e){System.out.println(e);} 
	}
	
	private void editar(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		try {
		Materia materia = new Materia(Integer.parseInt(req.getParameter("clave_horario")), req.getParameter("clave_materia"),
				req.getParameter("materia"), Integer.parseInt(req.getParameter("semestre")), req.getParameter("carrera"), 
				req.getParameter("periodo"), req.getParameter("maestro"), req.getParameter("turno"), req.getParameter("campus"),
				req.getParameter("grupo"), Integer.parseInt(req.getParameter("no_alumnos")), Integer.parseInt(req.getParameter("creditos")), 
				Integer.parseInt(req.getParameter("horas_t")), Integer.parseInt(req.getParameter("horas_p")), req.getParameter("lunes"),
				req.getParameter("martes"), req.getParameter("miercoles"), req.getParameter("jueves"), req.getParameter("viernes"), 
				req.getParameter("salon"));
		materiaDAO.actualizarMateria(materia);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/listar_materias.jsp");
		}catch(Exception e){System.out.println(e);} 
	}
	
	private void eliminar(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		try {
		Materia materia = materiaDAO.obtenerID(Integer.parseInt(req.getParameter("clave_horario")));
		materiaDAO.eliminarMateria(materia);
		
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/listar_materias.jsp");
		}catch(Exception e){System.out.println(e);} 
	}
}