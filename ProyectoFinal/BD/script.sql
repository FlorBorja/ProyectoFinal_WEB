create database proyecto;

use proyecto;

create table usuario (
	id_usuario int not null AUTO_INCREMENT,
	clave_maestro varchar(25) not null,
	prefijo varchar(5) not null,
	nombre varchar(50) not null,
	correo varchar(50) not null,
	telefono int not null,
	departamento varchar(25) not null,
	usuario varchar(25) not null,
	password varchar(25) not null,
	rol varchar(25) not null,
	
	primary key(id_usuario)
);

create table carrera(
	id_carrera int not null AUTO_INCREMENT,
	clave_carrera varchar(50) not null,
	carrera varchar(50) not null,
	turno varchar(25) not null,
	
	primary key(id_carrera)
);

create table maestroxcarrera(
	id_maestro int not null AUTO_INCREMENT,
	id_carrera int not null,
	id_usuario int not null,
	
	primary key(id_maestro),
	foreign key(id_carrera) references carrera(id_carrera),
	foreign key(id_usuario) references usuario(id_usuario)
);

create table materias(
	id_materia int not null AUTO_INCREMENT,
	clave_horario int not null,
	clave_materia varchar(50) not null,
	materia varchar(50) not null, 
	semestre int not null,
	carrera varchar(50) not null,
	periodo varchar (25) not null,
	maestro varchar(50) not null,
	turno varchar(25) not null,
	campus varchar(25) not null,
	grupo varchar(1) not null,
	no_alumnos int not null,
	creditos int not null,
	horas_t int not null,
	horas_p int not null,
	lunes varchar(25),
	martes varchar(25),
	miercoles varchar(25),
	jueves varchar(25),
	viernes varchar(25),
	salon varchar(5),
	
	primary key(id_materia)
);

create table sabana(
	id_sabana int not null AUTO_INCREMENT,
	clave_horario int not null,
	clave_maestro varchar(25) not null,
	clave_materia varchar(7) not null,
	clave_carrera varchar(3) not null,
	materia varchar(50) not null,
	carrera varchar(50) not null,
	maestro varchar(50) not null,
	periodo varchar(25) not null,
	turno varchar(25) not null,
	nivel_estudio varchar(50) not null,
	grupo varchar(1) not null,
	campus varchar(25) not null,
	no_alumnos int not null,
	semestre int not null,
	creditos int not null,
	lunes varchar(25),
	martes varchar(25),
	miercoles varchar(25),
	jueves varchar(25),
	viernes varchar(25),
	salon varchar(5),
	horas_t int not null,
	horas_p int not null,
	
	primary key(id_sabana),
	
	foreign key(clave_materia) references materia(clave_materia)
);

/*---------------------------------------------------------------INSERCIONES---------------------------------------------------------------*/
-------------------------------------------------------------------USUARIO-----------------------------------------------------------------
insert into usuario (id_usuario,clave_maestro,prefijo,nombre,correo,telefono,departamento,usuario,password,rol) values
('', 'A00', 'Ing.', 'Administrador', 'admin@leon.tecnm.mx', '4771234567', 'Ciencias Bascias', 'admin', '123', 'administrador'),
('', 'A01', 'Ing.', 'Aguila Reyes Antonio', 'aguila@leon.tecnm.mx', '4771234567', 'Sistemas/TICS', 'aguila', '123', 'jefe_carrera'),
('', 'A02', 'Ing.', 'Carpio Flores Jose Gerardo', 'carpio@leon.tecnm.mx', '4771234567', 'Sistemas/TICS', 'carpio', '123', 'docente'),
('', 'A03', 'Lic.', 'Ramirez Alverez Irma de Jesus', 'irma@leon.tecnm.mx', '4771234567', 'Sistemas/TICS', 'irma','123', 'docente'),
('', 'A04', 'Ing.', 'Levy Rojas Carlos Rafael', 'levy@leon.tecnm.mx', '4771234567', 'Sistemas/TICS', 'levy', '123', 'docente'),
('', 'A05', 'Doc.', 'Maria del Rosario Baltazar Flores', 'baltazar@leon.tecnm.mx', '1234567', 'Sistemas/TICS', 'rosario', '123', 'docente'),
('', 'A06', 'Ing.', 'Cirino Silva Tovar', 'cirino@leon.tecnm.mx', '123454', 'Sistemas/TICS', 'cirino', '123', 'docente'),
('', 'A07', 'Ing.', 'Ruth Saez de Nanclarez Rodriguez', 'ruth@leon.tecnm.mx', 'Sistemas/TICS', 'ruth', '123', 'docente'),
('','A08', 'Mtro.', 'Garcia Marques Luis', 'garcia@leon.tecnm.mx', '4771234567', 'Ciencias Basicas', 'garciam' ,'123' ,'docente'),
('','A09', 'Ing.', 'Infante Medina Rogelio', 'infante@leon.tecnm.mx', '4771234567', 'Ciencias Basicas', 'infantem' ,'123' ,'docente'),
('', 'A10', 'Ing.', 'Edna Militza Martinez Prado', 'militza@leon.tecnm.mx', '123456', 'Sistemas/TICS', 'militza', '123', 'docente');

--------------------------------------------------------------------SABANA------------------------------------------------------------------
insert into sabana values('', 4011, 'A01', 'ACF0901', 'ISX', 'Cálculo Diferencial', 'Ingenieria en Sistemas Computacionales', 'Ing. Águila Reyes Antonio', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'E', 'Campus 1', 31, 1, 5, '10:30-12:10', '', '10:30-12:10', '', '10:30-11:20', 'C-5', 3, 2);
insert into sabana values('', 4013, 'A02', 'AED1285', 'ISX', 'Fundamentos de Programación', 'Ingenieria en Sistemas Computacionales', 'Ing. Carpio Flores José Gerardo', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.','A', 'Campus 1', 35, 1, 5, '', '12:35-13:55', '', '12:35-13:55', '13:05-13:55', 'C-LC3', 2, 3);
insert into sabana values('', 4023, 'A03', 'SCH1024', 'ISX', 'Taller de Administración', 'Ingenieria en Sistemas Computacionales', 'Lic. Ramírez Álvarez Irma De Jesús', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'A', 'Campus 1', 34, 1, 4, '7:00-8:40', '', '7:00-8:40', '', '', 'C-D1', 1, 3);
insert into sabana values('', 4025, 'A03', 'SCH1024', 'ISX', 'Taller de Administración', 'Ingenieria en Sistemas Computacionales', 'Lic. Ramírez Álvarez Irma De Jesús', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'C', 'Campus 1', 35, 1, 4, '10:30-12:10', '', '10:30-12:10', '', '', 'C-D3', 1, 3);
insert into sabana values('', 4027, 'A03','SCH1024', 'ISX', 'Taller de Administración', 'Ingenieria en Sistemas Computacionales', 'Lic. Ramírez Álvarez Irma De Jesús', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'E', 'Campus 1', 31, 1, 4, '', '12:15-13:55', '', '12:15-13:55', '', 'C-D5', 1, 3);
insert into sabana values('', 4028, 'A03', 'ACC0906', 'ISX', 'Fundamentos de Investigación', 'Ingenieria en Sistemas Computacionales', 'Lic. Ramírez Álvarez Irma De Jesús', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'A', 'Campus 1', 34, 1, 4, '', '7:00-8:40', '', '7:00-8:40', '', 'C-D1', 2, 2);
insert into sabana values('', 4032, 'A03', 'ACC0906', 'ISX', 'Fundamentos de Investigación', 'Ingenieria en Sistemas Computacionales', 'Lic. Ramírez Álvarez Irma De Jesús', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'E', 'Campus 1', 31, 1, 4, '12:15-13:55', '', '12:15-13:55', '', '', 'C-D5', 2, 2);
insert into sabana values('', 4042, 'A02','AED1286', 'ISX', 'Programación Orientada a Objetos', 'Ingenieria en Sistemas Computacionales', 'Ing. Carpio Flores José Gerardo', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'B', 'Campus 1', 22, 2, 5, '12:15-13:55', '', '12:15-13:55', '', '12:15-13:05', 'C-D15', 2, 3);
insert into sabana values('', 4043, 'A02','AED1286', 'ISX', 'Programación Orientada a Objetos', 'Ingenieria en Sistemas Computacionales', 'Ing. Carpio Flores José Gerardo', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'C', 'Campus 1', 22, 2, 5, '7:00-8:40', '', '7:00-8:40', '', '7:00-7:50', 'C-D15', 2, 3);
insert into sabana values('', 4045, 'A03','AEC1008', 'ISX', 'Contabilidad Financiera', 'Ingenieria en Sistemas Computacionales', 'Lic. Ramírez Álvarez Irma de Jesús', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'A', 'Campus 1', 26, 2, 4, '', '10:30-12:10', '', '10:30-12:10', '', 'C-D2', 2, 2);
insert into sabana values('', 4073, 'A04','SCD1027', 'ISX', 'Tópicos Avanzados de Programación', 'Ingenieria en Sistemas Computacionales', 'Ing. Levy Rojas Carlos Rafael', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'A', 'Campus 1', 19, 4, 5, '', '12:15-13:55', '', '12:15-13:55', '13:05-13:55', 'C-D15', 2, 3);
insert into sabana values('', 4096, 'A04','SCA1025', 'ISX', 'Taller de Base de Datos', 'Ingenieria en Sistemas Computacionales', 'Ing. Levy Rojas Carlos Rafael', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'B', 'Campus 1', 10, 5, 4, '8:45-10:25', '', '8:45-10:25', '', '', 'C-D11', 0, 4);
insert into sabana values('', 4167, 'A02','SCC1019', 'ISX', 'Programación Lógica y Funcional', 'Ingenieria en Sistemas Computacionales', 'Ing. Carpio Flores José Gerardo', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'A', 'Campus 1', 21, 8, 4, '', '7:00-8:40', '', '7:00-8:40', '', 'C-D9', 2, 2);
insert into sabana values('', 4168, 'A02','SCC1019', 'ISX', 'Programación Lógica y Funcional', 'Ingenieria en Sistemas Computacionales', 'Ing. Carpio Flores José Gerardo', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'B', 'Campus 1', 14, 8, 4, '', '8:45-10:25', '', '8:45-10:25', '', 'C-D9', 2, 2);
insert into sabana values('', 4181, 'A04','DAD1403', 'ISX', 'Programación Web Avanzada', 'Ingenieria en Sistemas Computacionales', 'Ing. Levy Rojas Carlos Rafael', 
'Agosto-Diciembre 2020', 'Matutino', 'Licenciatura o Equiv.', 'A', 'Campus 1', 20, 9, 5, '10:30-12:10', '', '10:30-12:10', '', '10:30-11:20', 'C-LC1', 2, 3);


