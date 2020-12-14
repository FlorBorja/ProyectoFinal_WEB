<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.flor.dao.ReporteDAO, com.flor.modelo.Reporte, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Reporte</title>

    <!-- Bootstrap core CSS -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" 
     integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	
  	<style>
	  	body {
		  padding-top: 50px;
		}
		.starter-template {
		  padding: 40px 15px;
		  text-align: center;
		} 
		.container2 {
		  max-width: 38em;
		  padding: 1em 3em 2em 3em;
		  margin: 0em auto;
		  background-color: #fff;
		  border-radius: 4.2px;
		}
  	</style>
  
  </head>

  <body>
  
  <%
  String name=(String)session.getAttribute("user");
  String rol=(String)session.getAttribute("rol");
	System.out.println(name +" "+ rol);
	
	if(rol==null && name==null){
		response.sendRedirect("../ServletUsuario?action=login");
	}else{
		
		ReporteDAO reporteDAO = new ReporteDAO("jdbc:mysql://localhost/proyecto", "root", "");
		List<Reporte> listaReporte= reporteDAO.listarReporteP(name);
		request.setAttribute("lista", listaReporte);
	}
  %>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">TECNM</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
           <div id="navbar" class="navbar-collapse collapse">
           <ul class="nav navbar-nav">
            <li class="active"><a href="reporte.jsp">Inicio</a></li>
            </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="perfil_docente.jsp">Perfil</a></li>
            <li><a href="../ServletUsuario?action=cerrarSesion">Cerrar Sesión</a></li>
          </ul>
        </div>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
      <div class="starter-template">
        <h1>Reporte ${lista[0].getMaestro()}</h1><br>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                 <th>C.Maestro</th>
				 <th>C.Materia</th>
				 <th>Materia</th>
				 <th>Grupo</th>
				 <th>Aula</th>
				 <th>N.Alumnos</th>
				 <th>C.Carrera</th>
				 <th>Semestre</th>
				 <th>Lunes</th>
				 <th>Martes</th>
				 <th>Miércoles</th>
				 <th>Jueves</th>
				 <th>Viernes</th>
				 <th>HT</th>
				 <th>HP</th>
				 <th>Créditos</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="sabana" items="${lista}">
				<tr>
					<td><c:out value="${sabana.clave_maestro}"/></td>
					<td><c:out value="${sabana.clave_materia}"/></td>
					<td><c:out value="${sabana.materia}"/></td>
					<td><c:out value="${sabana.grupo}"/></td>
					<td><c:out value="${sabana.salon}"/></td>
					<td><c:out value="${sabana.no_alumnos}"/></td>
					<td><c:out value="${sabana.clave_carrera}"/></td>
					<td><c:out value="${sabana.semestre}"/></td>
					<td><c:out value="${sabana.lunes}"/></td>
					<td><c:out value="${sabana.martes}"/></td>
					<td><c:out value="${sabana.miercoles}"/></td>
					<td><c:out value="${sabana.jueves}"/></td>
					<td><c:out value="${sabana.viernes}"/></td>
					<td><c:out value="${sabana.horas_t}"/></td>
					<td><c:out value="${sabana.horas_p}"/></td>
					<td><c:out value="${sabana.creditos}"/></td>
				</tr>
			</c:forEach>
              </tbody>
            </table>
          </div>
      </div>
    </div><!-- /.container -->
  </body>
</html>