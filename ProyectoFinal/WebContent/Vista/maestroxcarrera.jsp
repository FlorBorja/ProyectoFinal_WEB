<%@ page import="com.flor.dao.DocenteDAO, com.flor.modelo.Docente, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    
		<title>Asignar docente</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" 
	     integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" 
		integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css -->
		
		<style type="text/css">
		*,
*:before,
*:after {
  box-sizing: border-box;
}
body {
  padding: 5em;
  font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;
  font-size: 15px;
  color: #b9b9b9;
  background-color: #e3e3e3;
}
h4 {
  color: #3572a7;
}
input,
input[type="radio"] + label,
input[type="checkbox"] + label:before,
select option,
select {
  width: 100%;
  padding: 1em;
  line-height: 1.4;
  background-color: #f9f9f9;
  border: 1px solid #e5e5e5;
  border-radius: 3px;
  -webkit-transition: 0.35s ease-in-out;
  -moz-transition: 0.35s ease-in-out;
  -o-transition: 0.35s ease-in-out;
  transition: 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
}
input:focus {
  outline: 0;
  border-color: #3572a7;
}
input:focus + .input-icon i {
  color: #3572a7;
}
input:focus + .input-icon:after {
  border-right-color:#3572a7;
}
input[type="radio"] {
  display: none;
}
input[type="radio"] + label,
select {
  display: inline-block;
  width: 50%;
  text-align: center;
  float: left;
  border-radius: 0;
}
input[type="radio"] + label:first-of-type {
  border-top-left-radius: 3px;
  border-bottom-left-radius: 3px;
}
input[type="radio"] + label:last-of-type {
  border-top-right-radius: 3px;
  border-bottom-right-radius: 3px;
}
input[type="radio"] + label i {
  padding-right: 0.4em;
}
input[type="radio"]:checked + label,
input:checked + label:before,
select:focus,
select:active {
  background-color:#3572a7;
  color: #fff;
  border-color: #2e6da4;
}
input[type="checkbox"] + label:before {
  position: absolute;
  top: 0.2em;
  left: 0;
  display: block;
  width: 1em;
  height: 1em;
  padding: 0;
  content: "";
}
input[type="checkbox"] + label:after {
  position: absolute;
  top: 0.45em;
  left: 0.2em;
  font-size: 0.8em;
  color: #fff;
  opacity: 0;
  font-family: FontAwesome;
  content: "\f00c";
}
input:checked + label:after {
  opacity: 1;
}
select {
  height: 3.4em;
  line-height: 2;
}
select:first-of-type {
  border-top-left-radius: 3px;
  border-bottom-left-radius: 3px;
}
select:last-of-type {
  border-top-right-radius: 3px;
  border-bottom-right-radius: 3px;
}
select:focus,
select:active {
  outline: 0;
}
select option {
  background-color: #417aab;
  color: #fff;
}
.input-group {
  margin-bottom: 1em;
  zoom: 1;
}
.input-group:before,
.input-group:after {
  content: "";
  display: table;
}
.input-group:after {
  clear: both;
}
.input-group-icon {
  position: relative;
}
.input-group-icon input {
  padding-left: 4.4em;
}
.input-group-icon .input-icon {
  position: absolute;
  top: 0;
  left: 0;
  width: 3.4em;
  height: 3.4em;
  line-height: 3.4em;
  text-align: center;
  pointer-events: none;
}
.input-group-icon .input-icon:after {
  position: absolute;
  top: 0.6em;
  bottom: 0.6em;
  left: 3.4em;
  display: block;
  border-right: 1px solid #e5e5e5;
  content: "";
  -webkit-transition: 0.35s ease-in-out;
  -moz-transition: 0.35s ease-in-out;
  -o-transition: 0.35s ease-in-out;
  transition: 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
}
.input-group-icon .input-icon i {
  -webkit-transition: 0.35s ease-in-out;
  -moz-transition: 0.35s ease-in-out;
  -o-transition: 0.35s ease-in-out;
  transition: 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
}
.container2 {
  max-width: 38em;
  padding: 1em 3em 2em 3em;
  margin: 0em auto;
  background-color: #fff;
  border-radius: 4.2px;
  box-shadow: 0px 3px 10px -2px rgba(0, 0, 0, 0.2);
}
.col-half {
  padding-right: 10px;
  float: left;
  width: 50%;
}
.col-half:last-of-type {
  padding-right: 0;
}
.col-third {
  padding-right: 10px;
  float: left;
  width: 33.33333333%;
}
.col-third:last-of-type {
  padding-right: 0;
}
@media only screen and (max-width: 540px) {
  .col-half {
    width: 100%;
    padding-right: 0;
  }
}
input{
color:black;
}
select{
width:100%;
color:black;
}		
h3{
text-align:center;
color:#847c7c;
}
.btn {
	padding: 10px 16px;
	font-size: 18px;
	line-height: 1.333333;
	border-radius: 6px;
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
	text-decoration:none;
	display: table-cell;
	display:block;
  margin-left: auto;
  margin-right: auto;
  text-align:center;
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
		int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
		
		DocenteDAO docenteDAO = new DocenteDAO("jdbc:mysql://localhost/proyecto", "root", "");
		
		List<Docente> listaDocente= docenteDAO.listarDocentes();
		request.setAttribute("lista", listaDocente);
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
          <ul class="nav navbar-nav">
            <li class="active"><a href="menu_administrador.jsp">Inicio</a></li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Carreras<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="registrar_carrera.jsp">Registrar</a></li>
              </ul>
            </li>
          </ul>
           <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="perfil_admin.jsp">Perfil</a></li>
            <li><a href="../ServletUsuario?action=cerrarSesion">Cerrar sesion</a></li>
          </ul>
        </div>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <!--script type="text/javascript">
	    var x = location.search;
	
	    //Mostramos los valores en consola:
	    console.log(x);
	    //document.getElementById("myURL").value = "8";
	    //Creamos la instancia
	    var urlParams = new URLSearchParams(x);
	
	    //Accedemos a los valores
	    var producto = urlParams.get('id_carrera');
	    console.log(producto);
	    document.getElementById("id_carrera").value = producto;
	    <c:forEach var="usuario" items="${lista}">
					<option value=4><c:out value="${usuario.nombre_c}"></c:out></option>
				</c:forEach>
    </script-->

	<div class="container2">
	  <form action="../ServletDocente?action=asignarDocente" method="post">
	      <h3>Asignar docente</h3>
	      <hr width="75%">
	      <input type="hidden" id="id_carrera" name="id_carrera" value="<%=Integer.parseInt(request.getParameter("id_carrera"))%>">
	        <h4>Seleccione el nombre del docente</h4>
	        <div class="input-group">
	          <select id="id_usuario" name="id_usuario">
	            <c:forEach var="usuario" items="${lista}">
					<option value="${usuario.id_usuario}"><c:out value="${usuario.nombre_c}"></c:out></option>
				</c:forEach>
	          </select>
	      </div>
	      
	      <br>
	     <button class="btn btn-primary" type="submit">Asignar &raquo;</button>	  
	      </form>
	    </div>
	</body>
</html>