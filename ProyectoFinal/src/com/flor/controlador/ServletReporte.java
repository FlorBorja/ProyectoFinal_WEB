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

import com.flor.dao.ReporteDAO;
import com.flor.modelo.Reporte;

/**
 * Servlet implementation class ServletMaestro
 */
@WebServlet("/ServletReporte")
public class ServletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReporteDAO reporteDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			reporteDAO = new ReporteDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletReporte() {}

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
			case "listarMaestros":
				listarMaestros(req, res);
				break;
			case "reporteMaestro":
				reporteMaestro(req, res);
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
	
	private void listarMaestros(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		//HttpSession session=req.getSession();
		//if(session.getAttribute("rol").equals(1)){
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/listar_maestros.jsp");
		List<Reporte> listaMaestro= reporteDAO.listarMaestro();
		req.setAttribute("lista", listaMaestro);
		dispatcher.forward(req, res);
		//}else{} 
	}
	
	private void reporteMaestro(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		//HttpSession session=req.getSession();
		//if(session.getAttribute("rol").equals(1)){
		List<Reporte> listaReporte= reporteDAO.listarReporte(req.getParameter("clave_maestro"));
		req.setAttribute("lista", listaReporte);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Vista/reporte_maestros.jsp");
		dispatcher.forward(req, res);
		//}else{} 
	}
}
