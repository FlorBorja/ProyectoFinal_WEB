<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    
		<title>Sign Up</title>
     
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css -->
		
		<style type="text/css">
		*,
*:before,
*:after {
  box-sizing: border-box;
}
body {
  padding: 2em;
  font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
  font-size: 15px;
  color: #b9b9b9;
  background-color: #e3e3e3;
}
h4 {
  color: #3572a7;
}
h1 {
  color: black;
  text-align: center;
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
input[type="checkbox"] {
  display: none;
}
input[type="checkbox"] + label {
  position: relative;
  display: block;
  padding-left: 1.6em;
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
.container {
  max-width: 38em;
  padding: 1em 3em 2em 3em;
  margin: 0em auto;
  background-color: #fff;
  border-radius: 4.2px;
  box-shadow: 0px 3px 10px -2px rgba(0, 0, 0, 0.2);
}
.row {
  zoom: 1;
}
.row:before,
.row:after {
  content: "";
  display: table;
}
.row:after {
  clear: both;
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
  
	<div class="container">
	  <h1>Regístrate</h1>
	  <form action="ServletUsuario?action=registrar_Usuario" method="post">
	      <h4>Nombre</h4>
	      <div class="input-group input-group-icon">
	        <input type="text" name="nombre" placeholder="ej. Pérez Gómez Juan" required/>
	        <div class="input-icon"><i class="fa fa-user"></i></div>
	      </div>
	      <h4>Correo electrónico</h4>
	      <div class="input-group input-group-icon">
	        <input type="email" name="correo" placeholder="example@hotmail.com" required/>
	        <div class="input-icon"><i class="fa fa-envelope"></i></div>
	      </div>
	      <h4>Teléfono</h4>
	      <div class="input-group input-group-icon">
	        <input type="text" name="telefono" placeholder="teléfono" required/>
	        <div class="input-icon"><i class="fa fa-phone"></i></div>
	      </div>
	      <h4>Departamento</h4>
	        <div class="input-group">
	          <select name="departamento" required>
	            <option>Sistemas</option>
	            <option>Gestión Empresarial</option>
	            <option>Electromecánica</option>
	          </select>
	        </div>
	      <h4>Usuario</h4>
	      <div class="input-group input-group-icon">
	        <input type="text" name="usuario" placeholder="Nombre de usuario" required/>
	        <div class="input-icon"><i class="fa fa-user"></i></div>
	      </div>
	      <h4>Contraseña</h4>
	      <div class="input-group input-group-icon">
	        <input type="password" name="password" placeholder="Password" required/>
	        <div class="input-icon"><i class="fa fa-key"></i></div>
	      </div>
	      <h4>Rol</h4>
	      <div class="row"> 
	        <div class="input-group">
	          <input id="rol-jefe" type="radio" name="rol" value="jefe" required/>
	          <label for="rol-jefe">jefe</label>
	          <input id="rol-profesor" type="radio" name="rol" value="profesor" required/>
	          <label for="rol-profesor">profesor</label>
	        </div>
	     </div>
	     <br>
	     <button class="btn" type="submit">Registrar &raquo;</button>
	  </form>
	  <br>
	</div>
	</body>
</html>