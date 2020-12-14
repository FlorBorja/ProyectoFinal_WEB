# ProyectoFinal_WEB 
Proyecto Final de la materia "Programación Web Avanzada"

Software desarrollado para gestionar el manejo de materias en el TECNM.

Tiene la capacidad de realizar las siguientes acciones:

* Crear, editar y borrar una materia.
* Cargar un archivo separado por comas(csv) con las materias x carrera.
* Un listado de la Sabana de materias que se ofrecen, por carrera.
* Reporte de materias x profesor. (Los profesores pueden dar clases en diferentes carreras).
* Verifica que un profesor no se le empalme un horario.
* Perfil del usuario (Nombre, correo, teléfono, departamento).
El sistema debe de contar con roles para acceso a la información, dependiendo del tipo de usuario:
  * Rol de administrador: Crear carreras, asignar jefes y profesores por carrera.
  * Rol de Jefe de Carrera: Listar, añadir, cargar, borrar y editar Materias; ver la sabana y reportes de 
                            materias por maestro, de la carrera a su cargo.
                            Si el jefe maneja 2 carreras, debe de poder escoger con que carrera trabajar.
  * Rol de profesor: Ver SU reporte de materias.

# Comenzando :rocket:
*Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.*

## Pre-requisitos :page_facing_up:
* Para el desarrollo de este proyecto se utilizó Eclipse IDE for Enterprise Java Developers Version: 2020-06 (4.16.0).
* Se utiliza el servidor Apache Tomcat version 9.0.37.
* XAMPP para el servidor MySQL.

## Clonar el proyecto :eyes:
1. Abrir la terminal de preferencia
2. Ubicarse en la carpeta donde se desee clonar el proyecto.
3. Pega el siguiente comando en la terminal:
```
git clone https://github.com/FlorBorja/ProyectoFinal_WEB.git
```

## Ejecutando el proyecto :wrench:
1. Abrir el IDE de Eclipse.
2. Verifica que que se tenga instalado el servidor Apache Tomcat
3. Enciende los servicios de MySQL de XAMPP para poder utilizar la base de datos *proyecto*.
4. Ejecutar el archivo index.jsp que se encuentra dentro del proyecto dando click derecho y eligiendo el servidor de Tomcat instalado.

¡Listo! :thumbsup: Ya podrás ver el proyecto ejecutandose en tu computador.

# Demo :computer:
### Menú del administrador
![alt-text](https://media.giphy.com/media/YpgUUHpq7Ny1W3zDKg/giphy.gif)
### Menú del jefe de carrera
![alt-text](https://media.giphy.com/media/vBXkUXQbCznWmgaGGc/giphy.gif)
### Menú del docente
![alt-text](https://media.giphy.com/media/hWUMk7RGhJUSArWXrh/giphy.gif)

# Docker :whale:
 Este proyecto también puede ser ejecutado con la ayuda de Docker.
 Para ello solo se debe de ejecutar el achivo
```
docker-compose.yml
```
 
# Credenciales de Usuario :woman:
Credenciales para el usuario "administrador".
```
usuario: admin 
password: 123
```
Credenciales para el usuario "jefe de carrera".
```
usuario: aguila
password: 123
```
Credenciales para el usuario "docente".
```
usuario: carpio
password: 123
```
# Archivos del proyecto
https://raw.githubusercontent.com/FlorBorja/ProyectoFinal_WEB/master/assets/proyecto_nav.png

##
Hecho por :hibiscus:
