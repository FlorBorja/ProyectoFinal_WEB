package com.flor.controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flor.dao.DocenteDAO;
import com.flor.modelo.Docente;

@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DocenteDAO docenteDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			docenteDAO = new DocenteDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDocente() {}

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
			case "index":
				index(req, res);
				break;
			case "showDocentes":
				showDocentes(req, res);
				break;
			case "asignarDocente":
				asignarDocente(req, res);
				break;
			case "cerrarSesion":
				cerrarSesion(req, res);
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
	
	private void index(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
	
	private void showDocentes(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		try {
		List<Docente> listaDocenteCarrera = docenteDAO.listarDocentesCarrera(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("doce", listaDocenteCarrera);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/ver_docentes.jsp");
		}catch(Exception e){System.out.println(e);} 
	}
	
	private void asignarDocente(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		try {
		Docente docente = new Docente(Integer.parseInt(req.getParameter("id_carrera")), Integer.parseInt(req.getParameter("id_usuario")));
		docenteDAO.asignarDocente(docente);
		res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/menu_administrador.jsp");
		//RequestDispatcher disp = req.getRequestDispatcher("/Vista/menu_administrador.jsp");
		//disp.forward(req, res);
		}catch(Exception e){System.out.println(e);} 
	}
	
	private void cerrarSesion(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		HttpSession session = req.getSession();
		System.out.println("Se cerrara la siguiente sesión: "+session.getAttribute("user"));
		//session.removeAttribute("name");
		session.invalidate();
		System.out.println("Se ha cerrado la sesión de manera exitosa");
		index(req, res);
	}
}

