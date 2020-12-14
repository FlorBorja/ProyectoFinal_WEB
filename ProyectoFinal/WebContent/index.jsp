<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


    <title>Sign In</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
	<style type="text/css">
	@import url(Vista/css/login.css);
	.btn-primary {
	background-color:#337ab7;
	}
	</style>
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="ServletUsuario?action=validarUsuario" method="post">
        <h2 class="form-signin-heading">Iniciar sesión</h2>
        <label for="inputUsuario" class="sr-only">Usuario</label>
        <input type="text" id="inputUsuario" class="form-control" name="usuario" placeholder="Nombre de usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <label>¿No estas registrado?</label><a href="ServletUsuario?action=nuevoUsuario"> Crea una.</a>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      
    </div> <!-- /container -->

  </body>
</html>