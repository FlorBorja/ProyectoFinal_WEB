package com.flor.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flor.dao.SabanaDAO;
import com.flor.modelo.Sabana;

/**
 * Servlet implementation class ServletSabana
 */
@WebServlet("/ServletSabana")
public class ServletSabana extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	SabanaDAO sabanaDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			sabanaDAO = new SabanaDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSabana() {}

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
			case "listarSabana":
				listarSabana(req, res);
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
		System.out.print(getServletContext().getInitParameter("jdbcURL")+" " );
		doGet(req, res);
	}
	
	private void listarSabana(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		//HttpSession session=req.getSession();
		//if(session.getAttribute("rol").equals(1)){
			
			List<Sabana> listaSabana= sabanaDAO.listarSabana();
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/menu_jefe.jsp");
			req.setAttribute("lista", listaSabana);
			dispatcher.forward(req, res);
		//}else{} 
	}
}