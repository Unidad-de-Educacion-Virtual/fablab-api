-- Insertar datos en la tabla rol
INSERT INTO rol (id, descripcion) VALUES
(1, 'ADMIN'),
(2, 'INSTRUCTOR');

-- Insertar datos en la tabla tipo_documento
INSERT INTO `tipo_documento` (`id`, `descripcion`) VALUES
(1, 'Cédula de ciudadanía'),
(2, 'Tarjeta de identidad'),
(3, 'Pasaporte'),
(4, 'Cédula de extranjería'),
(5, 'Registro civil');

-- Insertar datos en la tabla municipio
INSERT INTO municipio (id, dane, nombre) VALUES
(1, '05001', 'Medellín'),
(2, '05002', 'Abejorral'),
(3, '05004', 'Abriaquí'),
(4, '05021', 'Alejandría'),
(5, '05030', 'Amagá'),
(6, '05042', 'Amalfi'),
(7, '05051', 'Andes'),
(8, '05060', 'Angelópolis'),
(9, '05061', 'Angostura'),
(10, '05062', 'Anzá'),
(11, '05065', 'Apartadó'),
(12, '05079', 'Argelia'),
(13, '05085', 'Armenia'),
(14, '05086', 'Barbosa'),
(15, '05088', 'Belmira'),
(16, '05091', 'Bello'),
(17, '05094', 'Betania'),
(18, '05095', 'Betulia'),
(19, '05101', 'Ciudad Bolívar'),
(20, '05104', 'Caicedo');


-- Insertar datos en la tabla ubicacion
INSERT INTO ubicacion (id, nombre) VALUES
(1, 'Auditorio principal'),
(2, 'Aula 1'),
(3, 'Aula 2'),
(4, 'Laboratorio de informática'),
(5, 'Biblioteca'),
(6, 'Cancha'),
(7, 'Salón de usos múltiples'),
(8, 'Aula virtual'),
(9, 'Plataforma online'),
(10, 'Centro comunitario'),
(11, 'Parque'),
(12, 'Colegio A'),
(13, 'Colegio B'),
(14, 'Colegio C'),
(15, 'Colegio D'),
(16, 'Colegio E'),
(17, 'Colegio F'),
(18, 'Colegio G'),
(19, 'Colegio H'),
(20, 'Colegio I');


-- Insertar datos en la tabla colegio
INSERT INTO colegio (id, municipio_id, dane, nombre) VALUES
(1, 1, '1234567', 'Colegio San Juan'),
(2, 1, '7654321', 'Institución Educativa La Salle'),
(3, 2, '9876543', 'Escuela Normal Superior'),
(4, 3, '1357913', 'Colegio Nacional de Abriaquí'),
(5, 4, '2468102', 'Colegio la Alegria'),
(6, 5, '3579135', 'Colegio Amagá'),
(7, 6, '4681024', 'Colegio Amalfi'),
(8, 7, '5791357', 'Colegio Andes'),
(9, 8, '6810246', 'Colegio Angelópolis'),
(10, 9, '7913579', 'Colegio Angostura'),
(11, 10, '8102468', 'Colegio Anzá'),
(12, 11, '9135791', 'Colegio Apartadó'),
(13, 12, '1024681', 'Colegio Argelia'),
(14, 13, '2468102', 'Colegio Armenia'),
(15, 14, '3579135', 'Colegio Barbosa'),
(16, 15, '4681024', 'Colegio Belmira'),
(17, 16, '5791357', 'Colegio Bello'),
(18, 17, '6810246', 'Colegio Betania'),
(19, 18, '7913579', 'Colegio Betulia'),
(20, 19, '8102468', 'Colegio Ciudad Bolívar');



-- Insertar datos en la tabla taller
INSERT INTO taller (id, descripcion, nombre) VALUES
(1, 'Taller de programación básica en Python', 'Python Básico'),
(2, 'Introducción al diseño gráfico con Adobe Photoshop', 'Photoshop para principiantes'),
(3, 'Taller de robótica educativa con LEGO Mindstorms', 'Robótica con LEGO'),
(4, 'Creación de videojuegos 2D con Unity', 'Desarrollo de videojuegos 2D'),
(5, 'Taller de emprendimiento juvenil', 'Emprendimiento'),
(6, 'Introducción a la impresión 3D', 'Impresión 3D'),
(7, 'Taller de fotografía digital', 'Fotografía Digital'),
(8, 'Desarrollo de páginas web con HTML, CSS y JavaScript', 'Desarrollo Web'),
(9, 'Introducción a la inteligencia artificial', 'Inteligencia Artificial'),
(10, 'Taller de liderazgo y trabajo en equipo', 'Liderazgo'),
(11, 'Taller de oratoria y comunicación efectiva', 'Oratoria'),
(12, 'Taller de escritura creativa', 'Escritura Creativa'),
(13, 'Taller de música', 'Música'),
(14, 'Taller de arte', 'Arte'),
(15, 'Taller de deporte', 'Deporte'),
(16, 'Taller de cocina', 'Cocina'),
(17, 'Taller de primeros auxilios', 'Primeros Auxilios'),
(18, 'Taller de manejo de conflictos', 'Manejo de Conflictos'),
(19, 'Taller de finanzas personales', 'Finanzas Personales'),
(20, 'Taller de marketing digital', 'Marketing Digital');


-- Insertar datos en la tabla participante
INSERT INTO participante (id, colegio_id, tipo_documento_id, nombre) VALUES
(1, 1, 1, 'Juan Pérez'),
(2, 2, 2, 'Maria González'),
(3, 3, 1, 'Pedro Rodríguez'),
(4, 4, 2, 'Ana López'),
(5, 5, 1, 'Carlos Martínez'),
(6, 6, 2, 'Sofia Hernández'),
(7, 7, 1, 'David García'),
(8, 8, 2, 'Laura Ramírez'),
(9, 9, 1, 'Miguel Ruiz'),
(10, 10, 2, 'Isabella Moreno'),
(11, 11, 1, 'Sebastián Vargas'),
(12, 12, 2, 'Valentina Castro'),
(13, 13, 1, 'Daniel Herrera'),
(14, 14, 2, 'Camila Suárez'),
(15, 15, 1, 'Alejandro Muñoz'),
(16, 16, 2, 'Mariana Ortega'),
(17, 17, 1, 'Mateo Santos'),
(18, 18, 2, 'Valeria Franco'),
(19, 19, 1, 'Santiago Gómez'),
(20, 20, 2, 'Luisa Silva');


-- Insertar datos en la tabla user
INSERT INTO user (id, instructor_id, rol_id, email, password) VALUES
(1, NULL, 2, 'instructor1@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(2, NULL, 2, 'instructor2@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(3, NULL, 2, 'instructor3@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(4, NULL, 2, 'instructor4@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(5, NULL, 2, 'instructor5@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(6, NULL, 2, 'instructor6@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(7, NULL, 2, 'instructor7@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(8, NULL, 2, 'instructor8@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(9, NULL, 2, 'instructor9@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(10, NULL, 2, 'instructor10@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(11, NULL, 2, 'instructor11@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(12, NULL, 2, 'instructor12@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(13, NULL, 2, 'instructor13@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(14, NULL, 2, 'instructor14@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(15, NULL, 2, 'instructor15@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(16, NULL, 2, 'instructor16@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(17, NULL, 2, 'instructor17@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(18, NULL, 2, 'instructor18@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(19, NULL, 2, 'instructor19@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(20, NULL, 2, 'instructor20@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(21, NULL, 1, 'admin@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'), -- Contraseña: Password123
(22, NULL, 1, 'admin2@localhost', '$2a$12$yoUTgtb19yhlMKbGfEiT4OpV/N7ww0G52gkbfHJ8zfYlkXxRCj.5W'); -- Contraseña: Password123

-- Insertar datos en la tabla instructor
INSERT INTO instructor (id, user_id, documento, nombre) VALUES
(1, 1, '1234567890', 'Instructor 1'),
(2, 2, '9876543210', 'Instructor 2'),
(3, 3, '1357913579', 'Instructor 3'),
(4, 4, '2468102468', 'Instructor 4'),
(5, 5, '3579135791', 'Instructor 5'),
(6, 6, '4681024681', 'Instructor 6'),
(7, 7, '5791357913', 'Instructor 7'),
(8, 8, '6810246810', 'Instructor 8'),
(9, 9, '7913579135', 'Instructor 9'),
(10, 10, '8102468102', 'Instructor 10'),
(11, 11, '9135791357', 'Instructor 11'),
(12, 12, '1024681024', 'Instructor 12'),
(13, 13, '2468102468', 'Instructor 13'),
(14, 14, '3579135791', 'Instructor 14'),
(15, 15, '4681024681', 'Instructor 15'),
(16, 16, '5791357913', 'Instructor 16'),
(17, 17, '6810246810', 'Instructor 17'),
(18, 18, '7913579135', 'Instructor 18'),
(19, 19, '8102468102', 'Instructor 19'),
(20, 20, '9135791357', 'Instructor 20');

UPDATE user
SET instructor_id = (
    SELECT id
    FROM instructor
    WHERE instructor.user_id = user.id
)
WHERE id IN (SELECT user_id FROM instructor);

-- Insertar datos en la tabla programacion (requiere datos en otras tablas)
INSERT INTO programacion (id, cantidad, fecha_fin, fecha_inicio, grado, colegio_id, instructor_id, taller_id, ubicacion_id, grupo, observacion) VALUES
(1, 20, '2024-12-31', '2024-11-28', 10, 1, 1, 1, 1, 'Grupo A', 'Observación 1'),
(2, 25, '2025-01-31', '2024-12-01', 11, 2, 2, 2, 2, 'Grupo B', 'Observación 2'),
(3, 15, '2025-02-28', '2025-01-15', 9, 3, 3, 3, 3, 'Grupo C', 'Observación 3'),
(4, 30, '2025-03-31', '2025-02-10', 10, 4, 4, 4, 4, 'Grupo D', 'Observación 4'),
(5, 22, '2025-04-30', '2025-03-15', 11, 5, 5, 5, 5, 'Grupo E', 'Observación 5'),
(6, 18, '2025-05-31', '2025-04-20', 9, 6, 6, 6, 6, 'Grupo F', 'Observación 6'),
(7, 28, '2025-06-30', '2025-05-10', 10, 7, 7, 7, 7, 'Grupo G', 'Observación 7'),
(8, 20, '2025-07-31', '2025-06-15', 11, 8, 8, 8, 8, 'Grupo H', 'Observación 8'),
(9, 16, '2025-08-31', '2025-07-20', 9, 9, 9, 9, 9, 'Grupo I', 'Observación 9'),
(10, 24, '2025-09-30', '2025-08-10', 10, 10, 10, 10, 10, 'Grupo J', 'Observación 10'),
(11, 20, '2025-10-31', '2025-09-15', 11, 11, 11, 11, 11, 'Grupo K', 'Observación 11'),
(12, 25, '2025-11-30', '2025-10-20', 9, 12, 12, 12, 12, 'Grupo L', 'Observación 12'),
(13, 15, '2025-12-31', '2025-11-15', 10, 13, 13, 13, 13, 'Grupo M', 'Observación 13'),
(14, 30, '2026-01-31', '2025-12-10', 11, 14, 14, 14, 14, 'Grupo N', 'Observación 14'),
(15, 22, '2026-02-28', '2026-01-15', 9, 15, 15, 15, 15, 'Grupo O', 'Observación 15'),
(16, 18, '2026-03-31', '2026-02-20', 10, 16, 16, 16, 16, 'Grupo P', 'Observación 16'),
(17, 28, '2026-04-30', '2026-03-10', 11, 17, 17, 17, 17, 'Grupo Q', 'Observación 17'),
(18, 20, '2026-05-31', '2026-04-15', 9, 18, 18, 18, 18, 'Grupo R', 'Observación 18'),
(19, 16, '2026-06-30', '2026-05-20', 10, 19, 19, 19, 19, 'Grupo S', 'Observación 19'),
(20, 24, '2026-07-31', '2026-06-10', 11, 20, 20, 20, 20, 'Grupo T', 'Observación 20');


-- Insertar datos en la tabla sesion (requiere datos en otras tablas)
INSERT INTO sesion (id, fecha, hora, instructor_id, programacion_id, ubicacion_id) VALUES
(1, '2024-11-28', '08:00:00.000000', 1, 1, 1),
(2, '2024-11-29', '08:00:00.000000', 1, 1, 1),
(3, '2024-12-01', '09:00:00.000000', 2, 2, 2),
(4, '2024-12-02', '09:00:00.000000', 2, 2, 2),
(5, '2025-01-15', '10:00:00.000000', 3, 3, 3),
(6, '2025-01-16', '10:00:00.000000', 3, 3, 3),
(7, '2025-02-10', '11:00:00.000000', 4, 4, 4),
(8, '2025-02-11', '11:00:00.000000', 4, 4, 4),
(9, '2025-03-15', '12:00:00.000000', 5, 5, 5),
(10, '2025-03-16', '12:00:00.000000', 5, 5, 5),
(11, '2025-04-20', '13:00:00.000000', 6, 6, 6),
(12, '2025-04-21', '13:00:00.000000', 6, 6, 6),
(13, '2025-05-10', '14:00:00.000000', 7, 7, 7),
(14, '2025-05-11', '14:00:00.000000', 7, 7, 7),
(15, '2025-06-15', '15:00:00.000000', 8, 8, 8),
(16, '2025-06-16', '15:00:00.000000', 8, 8, 8),
(17, '2025-07-20', '16:00:00.000000', 9, 9, 9),
(18, '2025-07-21', '16:00:00.000000', 9, 9, 9),
(19, '2025-08-10', '17:00:00.000000', 10, 10, 10),
(20, '2025-08-11', '17:00:00.000000', 10, 10, 10);


-- Insertar datos en la tabla asistente (requiere datos en otras tablas)
INSERT INTO asistente (id, participante_id, sesion_id) VALUES
(1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 4, 1), (5, 5, 1), (6, 6, 1), (7, 7, 1), (8, 8, 1), (9, 9, 1), (10, 10, 1),
(11, 11, 2), (12, 12, 2), (13, 13, 2), (14, 14, 2), (15, 15, 2), (16, 16, 2), (17, 17, 2), (18, 18, 2), (19, 19, 2), (20, 20, 2);

-- Insertar datos en la tabla inscripcion (requiere datos en otras tablas)
INSERT INTO inscripcion (id, fecha, participante_id, programacion_id) VALUES
(1, '2024-11-27', 1, 1), (2, '2024-11-27', 2, 1), (3, '2024-11-27', 3, 1), (4, '2024-11-27', 4, 1), (5, '2024-11-27', 5, 1), (6, '2024-11-27', 6, 1), (7, '2024-11-27', 7, 1), (8, '2024-11-27', 8, 1), (9, '2024-11-27', 9, 1), (10, '2024-11-27', 10, 1),
(11, '2024-11-27', 11, 2), (12, '2024-11-27', 12, 2), (13, '2024-11-27', 13, 2), (14, '2024-11-27', 14, 2), (15, '2024-11-27', 15, 2), (16, '2024-11-27', 16, 2), (17, '2024-11-27', 17, 2), (18, '2024-11-27', 18, 2), (19, '2024-11-27', 19, 2), (20, '2024-11-27', 20, 2);

-- Insertar datos en la tabla evidencia (requiere datos en otras tablas)
INSERT INTO evidencia (id, fecha, sesion_id, observacion, url) VALUES
(1, '2024-11-28', 1, 'Buena participación de los asistentes', 'url1.com'),
(2, '2024-11-29', 2, 'Algunos asistentes llegaron tarde', 'url2.com'),
(3, '2024-12-01', 3, 'Sesión exitosa', 'url3.com'),
(4, '2024-12-02', 4, 'Se necesitaron más recursos', 'url4.com'),
(5, '2025-01-15', 5, 'Participación activa', 'url5.com'),
(6, '2025-01-16', 6, 'Algunos problemas técnicos', 'url6.com'),
(7, '2025-02-10', 7, 'Sesión productiva', 'url7.com'),
(8, '2025-02-11', 8, 'Necesidad de mejorar la metodología', 'url8.com'),
(9, '2025-03-15', 9, 'Sesión muy interesante', 'url9.com'),
(10, '2025-03-16', 10, 'Buena organización', 'url10.com'),
(11, '2025-04-20', 11, 'Sesión corta', 'url11.com'),
(12, '2025-04-21', 12, 'Excelente participación', 'url12.com'),
(13, '2025-05-10', 13, 'Se requirio mas tiempo', 'url13.com'),
(14, '2025-05-11', 14, 'Sesión bien planteada', 'url14.com'),
(15, '2025-06-15', 15, 'Muy buena experiencia', 'url15.com'),
(16, '2025-06-16', 16, 'Falta de motivación', 'url16.com'),
(17, '2025-07-20', 17, 'Sesión enriquecedora', 'url17.com'),
(18, '2025-07-21', 18, 'Algunos problemas con los materiales', 'url18.com'),
(19, '2025-08-10', 19, 'Excelente trabajo en equipo', 'url19.com'),
(20, '2025-08-11', 20, 'Sesión excelente', 'url20.com');



-- **Nota:**  He usado la contraseña `Password123` para todos los usuarios. En un entorno real, esto es inaceptable.  Necesitas usar una función de hashing robusta como bcrypt (como indica el DDL) para generar contraseñas seguras para cada usuario. La función `$2a$10$...` ya realiza el hash bcrypt, pero el valor debe ser generado con una librería de bcrypt para cada contraseña diferente en lugar de usar el mismo valor repetido.  Recuerda que las contraseñas hasheadas  **no** se pueden revertir.
