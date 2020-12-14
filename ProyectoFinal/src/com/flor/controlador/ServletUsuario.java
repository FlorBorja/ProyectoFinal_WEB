package com.flor.controlador;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flor.dao.UsuarioDAO;
import com.flor.modelo.Usuario;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			usuarioDAO = new UsuarioDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {}

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
			case "login":
				login(req, res);
				break;
			case "validarUsuario":
				validarUsuario(req, res);
				break;
			case "nuevoUsuario":
				nuevoUsuario(req, res);
				break;
			case "registrar_Usuario":
				registrar_Usuario(req, res);
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
	
	private void login(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
	
	private void validarUsuario(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		String name, rol;
		Usuario user = new Usuario(usuario, password);	 
		
		HttpSession session=req.getSession();
		 switch(usuarioDAO.validar(user)){
			case "administrador":
				System.out.println(session.getAttribute("rol")+ " "+req.getParameter("usuario") + " " +req.getParameter("password"));
				session.setAttribute("user", usuario);
				session.setAttribute("rol", "administrador");
				name=(String)session.getAttribute("user");
				rol=(String)session.getAttribute("rol");
				//RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/menu_administrador.jsp");
				//dispatcher.forward(req, res);
				res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/menu_administrador.jsp");
				System.out.println(session.getAttribute("rol")+ " "+req.getParameter("usuario") + " " +req.getParameter("password"));
				//System.out.println("rol: "+req.getParameter("usuario") + " " +req.getParameter("usuario"));
				break;
			case "jefe_carrera":
				System.out.println(session.getAttribute("rol")+ " "+req.getParameter("usuario") + " " +req.getParameter("password"));
				session.setAttribute("user", usuario);
				session.setAttribute("rol", "jefe_carrera");
				name=(String)session.getAttribute("user");
				res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/seleccion.jsp");
				//RequestDispatcher dispatcher2 = req.getRequestDispatcher("/Vista/menu_docente.jsp");
				//dispatcher2.forward(req, res);
				System.out.println(session.getAttribute("rol")+ " "+req.getParameter("usuario") + " " +req.getParameter("password"));
				break;
			case "docente":
				System.out.println(session.getAttribute("rol")+ " "+req.getParameter("usuario") + " " +req.getParameter("password"));
				session.setAttribute("user", usuario);
				session.setAttribute("rol", "jefe_carrera");
				name=(String)session.getAttribute("user");
				res.sendRedirect("http://localhost:8080/ProyectoFinal/Vista/reporte.jsp");
				//RequestDispatcher dispatcher2 = req.getRequestDispatcher("/Vista/menu_docente.jsp");
				//dispatcher2.forward(req, res);
				System.out.println(session.getAttribute("rol")+ " "+req.getParameter("usuario") + " " +req.getParameter("password"));
				break;
			default:
				System.out.println("<h3>El usuario es incorrecto o no existe</h3>");
				RequestDispatcher disp = req.getRequestDispatcher("index.jsp");
				disp.forward(req, res);
				System.out.println("DEFAULT: "+session.getAttribute("rol")+" "+ req.getParameter("usuario") + " " +req.getParameter("password"));
				System.out.print(" "+getServletContext().getInitParameter("jdbcURL")+" " );
				break;
		 }
	}
	
	private void registrar_Usuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		String Nombre = req.getParameter("nombre");
		String Correo = req.getParameter("correo");
		int Telefono = Integer.parseInt(req.getParameter("telefono"));
		String Departamento = req.getParameter("departamento");
		String Usuario = req.getParameter("usuario");
		String Pass = req.getParameter("password");
		String Rol = req.getParameter("rol");
		System.out.println(Nombre +" "+Correo+" "+Telefono+" "+Departamento+" "+Usuario+" "+Pass+" "+Rol);
		Usuario usuario = new Usuario(req.getParameter("nombre"), req.getParameter("correo"), Integer.parseInt(req.getParameter("telefono"))
				, req.getParameter("departamento"), req.getParameter("usuario"), req.getParameter("password"), req.getParameter("rol"));
		usuarioDAO.insertarUsuario(usuario);
		RequestDispatcher disp = req.getRequestDispatcher("index.jsp");
		disp.forward(req, res);
	}
	
	private void nuevoUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/registrar_usuario.jsp");
		dispatcher.forward(req, res);
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
