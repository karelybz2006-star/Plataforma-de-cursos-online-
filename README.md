# Plataforma de Cursos Online

## Descripción

Aplicación web donde docentes publican cursos con lecciones y los alumnos se inscriben, avanzan en su progreso y obtienen certificados al completar el 100% del curso.

## Integrantes

- Karely Baque
- Llivisaca Stefanny
- Jeremy Bohorquez

## Tecnologías

- Java 21
- Spring Boot 4
- Spring Security
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Maven

## Funcionalidades

### Docente
- Registro e inicio de sesión
- CRUD de cursos
- CRUD de lecciones
- Visualización de estadísticas

### Alumno
- Registro e inicio de sesión
- Inscripción a cursos
- Seguimiento del progreso
- Obtención de certificados

## Arquitectura

Arquitectura en capas:

- Presentación (Thymeleaf)
- Lógica de negocio (Servicios)
- Persistencia (JPA)
- Base de datos PostgreSQL

  ## Modelo de Datos

### Usuario
- id
- nombre
- correo
- contraseña
- rol (DOCENTE, ALUMNO)

### Curso
- id
- titulo
- descripcion
- docente_id

### Leccion
- id
- titulo
- contenido
- curso_id

### Inscripcion
- id
- usuario_id
- curso_id
- progreso

### Certificado
- id
- usuario_id
- curso_id
- fecha_emision

## Repositorio

Repositorio GitHub del proyecto académico.
