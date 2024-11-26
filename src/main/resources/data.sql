-- Insertar datos en la tabla tipo_documento
INSERT INTO tipo_documento (id, descripcion) VALUES
(1, 'Cédula de ciudadanía'),
(2, 'Tarjeta de identidad'),
(3, 'Pasaporte'),
(4, 'Cédula de extranjería'),
(5, 'Registro civil');

-- Insertar datos en la tabla municipio
INSERT INTO municipio (id, dane, nombre) VALUES
(1, '11001', 'Bogotá D.C.'),
(2, '05001', 'Medellín'),
(3, '08001', 'Cali'),
(4, '13001', 'Barranquilla'),
(5, '15001', 'Cartagena'),
(6, '19001', 'Bucaramanga'),
(7, '20001', 'Cúcuta'),
(8, '23001', 'Pereira'),
(9, '25001', 'Manizales'),
(10, '27001', 'Ibagué'),
(11, '33001', 'Pasto'),
(12, '41001', 'Neiva'),
(13, '44001', 'Valledupar'),
(14, '47001', 'Montería'),
(15, '50001', 'Sincelejo'),
(16, '52001', 'Riohacha'),
(17, '54001', 'Santa Marta'),
(18, '63001', 'Villavicencio'),
(19, '66001', 'Florencia'),
(20, '68001', 'Popayán');


-- Insertar datos en la tabla ubicacion
INSERT INTO ubicacion (id, nombre) VALUES
(1, 'Aula 1'),
(2, 'Aula 2'),
(3, 'Laboratorio de informática'),
(4, 'Biblioteca'),
(5, 'Auditorio'),
(6, 'Cancha'),
(7, 'Salón de profesores'),
(8, 'Cafetería'),
(9, 'Patio'),
(10, 'Zona verde'),
(11, 'Aula virtual'),
(12, 'Plataforma online'),
(13, 'Plataforma Zoom'),
(14, 'Plataforma Google Meet'),
(15, 'Plataforma Microsoft Teams'),
(16, 'Aula 3'),
(17, 'Aula 4'),
(18, 'Aula 5'),
(19, 'Aula 6'),
(20, 'Aula 7');

-- Insertar datos en la tabla taller
INSERT INTO taller (id, nombre, descripcion) VALUES
(1, 'Programación básica', 'Introducción a la programación con Python'),
(2, 'Diseño web', 'Creación de páginas web con HTML, CSS y JavaScript'),
(3, 'Robótica educativa', 'Construcción y programación de robots educativos'),
(4, 'Pensamiento computacional', 'Desarrollo del pensamiento lógico y algorítmico'),
(5, 'Inteligencia artificial', 'Introducción a la inteligencia artificial y el aprendizaje automático'),
(6, 'Big Data', 'Análisis de grandes conjuntos de datos'),
(7, 'Ciberseguridad', 'Protección de sistemas informáticos'),
(8, 'Desarrollo de videojuegos', 'Creación de videojuegos con Unity'),
(9, 'Realidad virtual', 'Experiencias de realidad virtual'),
(10, 'Realidad aumentada', 'Experiencias de realidad aumentada'),
(11, 'Diseño gráfico', 'Creación de diseños gráficos'),
(12, 'Edición de video', 'Edición de videos'),
(13, 'Animación 2D', 'Creación de animaciones 2D'),
(14, 'Animación 3D', 'Creación de animaciones 3D'),
(15, 'Modelado 3D', 'Creación de modelos 3D'),
(16, 'Impresión 3D', 'Uso de impresoras 3D'),
(17, 'Diseño de juegos de mesa', 'Creación de juegos de mesa'),
(18, 'Diseño de Apps', 'Creación de aplicaciones móviles'),
(19, 'Desarrollo de Apps', 'Desarrollo de aplicaciones móviles'),
(20, 'Internet de las cosas (IoT)', 'Introducción al Internet de las cosas');


-- Insertar datos en la tabla instructor
INSERT INTO instructor (id, documento, nombre) VALUES
(1, '123456789', 'Juan Pérez'),
(2, '987654321', 'Ana Gómez'),
(3, '112233445', 'Pedro López'),
(4, '554433221', 'Maria Rodriguez'),
(5, '101010101', 'Carlos Garcia'),
(6, '202020202', 'Laura Martinez'),
(7, '303030303', 'David Hernandez'),
(8, '404040404', 'Sofia Moreno'),
(9, '505050505', 'Miguel Ruiz'),
(10, '606060606', 'Valentina Ramírez'),
(11, '707070707', 'Sebastian Muñoz'),
(12, '808080808', 'Camila Alarcón'),
(13, '909090909', 'Nicolas Vargas'),
(14, '121212121', 'Isabella Ospina'),
(15, '131313131', 'Santiago Correa'),
(16, '141414141', 'Daniela Suarez'),
(17, '151515151', 'Alejandro Castro'),
(18, '161616161', 'Catalina Gomez'),
(19, '171717171', 'Juan David'),
(20, '181818181', 'Maria Paula');


-- Insertar datos en la tabla colegio
INSERT INTO colegio (id, municipio_id, dane, nombre) VALUES
(1, 1, '111111111', 'Colegio San José'),
(2, 2, '222222222', 'Colegio Nuestra Señora del Carmen'),
(3, 3, '333333333', 'Colegio La Salle'),
(4, 4, '444444444', 'Colegio San Pedro Claver'),
(5, 5, '555555555', 'Colegio Bolívar'),
(6, 6, '666666666', 'Colegio Santander'),
(7, 7, '777777777', 'Colegio La Paz'),
(8, 8, '888888888', 'Colegio Risaralda'),
(9, 9, '999999999', 'Colegio Caldas'),
(10, 10, '1010101010', 'Colegio Tolima'),
(11, 11, '1111111111', 'Colegio Nariño'),
(12, 12, '1212121212', 'Colegio Huila'),
(13, 13, '1313131313', 'Colegio Cesar'),
(14, 14, '1414141414', 'Colegio Córdoba'),
(15, 15, '1515151515', 'Colegio Sucre'),
(16, 16, '1616161616', 'Colegio La Guajira'),
(17, 17, '1717171717', 'Colegio Magdalena'),
(18, 18, '1818181818', 'Colegio Meta'),
(19, 19, '1919191919', 'Colegio Caquetá'),
(20, 20, '2020202020', 'Colegio Cauca');

-- Insertar datos en la tabla participante
INSERT INTO participante (id, colegio_id, tipo_documento_id, nombre) VALUES
(1, 1, 1, 'Juan Pérez'),
(2, 2, 2, 'Ana Gómez'),
(3, 3, 1, 'Pedro López'),
(4, 4, 2, 'Maria Rodriguez'),
(5, 5, 1, 'Carlos Garcia'),
(6, 6, 2, 'Laura Martinez'),
(7, 7, 1, 'David Hernandez'),
(8, 8, 2, 'Sofia Moreno'),
(9, 9, 1, 'Miguel Ruiz'),
(10, 10, 2, 'Valentina Ramírez'),
(11, 11, 1, 'Sebastian Muñoz'),
(12, 12, 2, 'Camila Alarcón'),
(13, 13, 1, 'Nicolas Vargas'),
(14, 14, 2, 'Isabella Ospina'),
(15, 15, 1, 'Santiago Correa'),
(16, 16, 2, 'Daniela Suarez'),
(17, 17, 1, 'Alejandro Castro'),
(18, 18, 2, 'Catalina Gomez'),
(19, 19, 1, 'Juan David'),
(20, 20, 2, 'Maria Paula');

-- Insertar datos en la tabla programacion
INSERT INTO programacion (id, colegio_id, instructor_id, taller_id, ubicacion_id, fecha_inicio, fecha_fin, cantidad, grado, grupo, observacion) VALUES
(1,1,1,1,1,'2024-11-25','2024-12-25',20,9,'A','Ninguna'),
(2,2,2,2,2,'2024-11-25','2024-12-25',20,10,'B','Ninguna'),
(3,3,3,3,3,'2024-11-25','2024-12-25',20,11,'C','Ninguna'),
(4,4,4,4,4,'2024-11-25','2024-12-25',20,12,'D','Ninguna'),
(5,5,5,5,5,'2024-11-25','2024-12-25',20,9,'E','Ninguna'),
(6,6,6,6,6,'2024-11-25','2024-12-25',20,10,'F','Ninguna'),
(7,7,7,7,7,'2024-11-25','2024-12-25',20,11,'G','Ninguna'),
(8,8,8,8,8,'2024-11-25','2024-12-25',20,12,'H','Ninguna'),
(9,9,9,9,9,'2024-11-25','2024-12-25',20,9,'I','Ninguna'),
(10,10,10,10,10,'2024-11-25','2024-12-25',20,10,'J','Ninguna'),
(11,11,11,11,11,'2024-11-25','2024-12-25',20,11,'K','Ninguna'),
(12,12,12,12,12,'2024-11-25','2024-12-25',20,12,'L','Ninguna'),
(13,13,13,13,13,'2024-11-25','2024-12-25',20,9,'M','Ninguna'),
(14,14,14,14,14,'2024-11-25','2024-12-25',20,10,'N','Ninguna'),
(15,15,15,15,15,'2024-11-25','2024-12-25',20,11,'O','Ninguna'),
(16,16,16,16,16,'2024-11-25','2024-12-25',20,12,'P','Ninguna'),
(17,17,17,17,17,'2024-11-25','2024-12-25',20,9,'Q','Ninguna'),
(18,18,18,18,18,'2024-11-25','2024-12-25',20,10,'R','Ninguna'),
(19,19,19,19,19,'2024-11-25','2024-12-25',20,11,'S','Ninguna'),
(20,20,20,20,20,'2024-11-25','2024-12-25',20,12,'T','Ninguna');


-- Insertar datos en la tabla sesion
INSERT INTO sesion (id, instructor_id, programacion_id, ubicacion_id, fecha, hora) VALUES
(1, 1, 1, 1, '2024-11-25', '08:00:00.000000'),
(2, 2, 2, 2, '2024-11-26', '09:00:00.000000'),
(3, 3, 3, 3, '2024-11-27', '10:00:00.000000'),
(4, 4, 4, 4, '2024-11-28', '11:00:00.000000'),
(5, 5, 5, 5, '2024-11-29', '12:00:00.000000'),
(6, 6, 6, 6, '2024-11-30', '13:00:00.000000'),
(7, 7, 7, 7, '2024-12-01', '14:00:00.000000'),
(8, 8, 8, 8, '2024-12-02', '15:00:00.000000'),
(9, 9, 9, 9, '2024-12-03', '16:00:00.000000'),
(10, 10, 10, 10, '2024-12-04', '17:00:00.000000'),
(11, 11, 11, 11, '2024-12-05', '08:00:00.000000'),
(12, 12, 12, 12, '2024-12-06', '09:00:00.000000'),
(13, 13, 13, 13, '2024-12-07', '10:00:00.000000'),
(14, 14, 14, 14, '2024-12-08', '11:00:00.000000'),
(15, 15, 15, 15, '2024-12-09', '12:00:00.000000'),
(16, 16, 16, 16, '2024-12-10', '13:00:00.000000'),
(17, 17, 17, 17, '2024-12-11', '14:00:00.000000'),
(18, 18, 18, 18, '2024-12-12', '15:00:00.000000'),
(19, 19, 19, 19, '2024-12-13', '16:00:00.000000'),
(20, 20, 20, 20, '2024-12-14', '17:00:00.000000');


-- Insertar datos en la tabla inscripcion
INSERT INTO inscripcion (id, participante_id, programacion_id, fecha) VALUES
(1, 1, 1, '2024-11-20'),
(2, 2, 2, '2024-11-20'),
(3, 3, 3, '2024-11-20'),
(4, 4, 4, '2024-11-20'),
(5, 5, 5, '2024-11-20'),
(6, 6, 6, '2024-11-20'),
(7, 7, 7, '2024-11-20'),
(8, 8, 8, '2024-11-20'),
(9, 9, 9, '2024-11-20'),
(10, 10, 10, '2024-11-20'),
(11, 11, 11, '2024-11-20'),
(12, 12, 12, '2024-11-20'),
(13, 13, 13, '2024-11-20'),
(14, 14, 14, '2024-11-20'),
(15, 15, 15, '2024-11-20'),
(16, 16, 16, '2024-11-20'),
(17, 17, 17, '2024-11-20'),
(18, 18, 18, '2024-11-20'),
(19, 19, 19, '2024-11-20'),
(20, 20, 20, '2024-11-20');


-- Insertar datos en la tabla asistente
INSERT INTO asistente (id, participante_id, sesion_id) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 15),
(16, 16, 16),
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20);

-- Insertar datos en la tabla evidencia
INSERT INTO evidencia (id, sesion_id, url, observacion) VALUES
(1, 1, 'https://picsum.photos/200/300', 'Participación activa de los estudiantes'),
(2, 2, 'https://picsum.photos/200/300', 'Buen trabajo en equipo'),
(3, 3, 'https://picsum.photos/200/300', 'Algunos estudiantes con dificultades'),
(4, 4, 'https://picsum.photos/200/300', 'Excelente desempeño general'),
(5, 5, 'https://picsum.photos/200/300', 'Necesidad de reforzar algunos conceptos'),
(6, 6, 'https://picsum.photos/200/300', 'Trabajo individual destacado'),
(7, 7, 'https://picsum.photos/200/300', 'Ambiente de aprendizaje positivo'),
(8, 8, 'https://picsum.photos/200/300', 'Algunos estudiantes distraídos'),
(9, 9, 'https://picsum.photos/200/300', 'Buen nivel de comprensión'),
(10, 10, 'https://picsum.photos/200/300', 'Necesidad de más ejemplos prácticos'),
(11, 11, 'https://picsum.photos/200/300', 'Excelente participación'),
(12, 12, 'https://picsum.photos/200/300', 'Trabajo en grupo eficiente'),
(13, 13, 'https://picsum.photos/200/300', 'Algunos estudiantes necesitan apoyo individual'),
(14, 14, 'https://picsum.photos/200/300', 'Desempeño satisfactorio'),
(15, 15, 'https://picsum.photos/200/300', 'Se requiere mayor práctica'),
(16, 16, 'https://picsum.photos/200/300', 'Excelente nivel de compromiso'),
(17, 17, 'https://picsum.photos/200/300', 'Buen clima de trabajo'),
(18, 18, 'https://picsum.photos/200/300', 'Algunos estudiantes con dudas'),
(19, 19, 'https://picsum.photos/200/300', 'Nivel de aprendizaje alto'),
(20, 20, 'https://picsum.photos/200/300', 'Se debe profundizar en algunos temas');
