# Proyecto Boletería-Test

Este proyecto es una prueba técnica para los aspirantes a ingresar a Vivetu, en el sector de boletería. Está construido utilizando Spring Boot y otras tecnologías clave para el desarrollo de aplicaciones Java con almacenamiento en base de datos y API REST.

## Tecnologías Utilizadas

### 1. **Spring Boot 3.3.3**
   - Framework de Java que simplifica la creación de aplicaciones independientes y de producción listas para funcionar. Se utiliza como base del proyecto.
   - **Consideraciones**:
     - Configuración mínima necesaria, gracias a su enfoque en la convención sobre la configuración.
     - Puede ejecutar la aplicación como un archivo `jar` o `war`, con un servidor web embebido.

### 2. **Spring Data JPA**
   - Proporciona una abstracción sobre JPA (Java Persistence API), facilitando el acceso y manipulación de bases de datos.
   - **Consideraciones**:
     - Simplifica el manejo de bases de datos mediante repositorios, eliminando gran parte del código boilerplate.
     - Utilizado en este proyecto para gestionar las operaciones de persistencia en la base de datos.

### 3. **Spring Boot Starter Web**
   - Este paquete proporciona todo lo necesario para construir aplicaciones web y API REST.
   - **Consideraciones**:
     - Incluye el servidor Tomcat embebido para simplificar el despliegue.
     - Facilita la creación de endpoints REST utilizando controladores (`@RestController`).

### 4. **H2 Database (Runtime)**
   - Base de datos en memoria utilizada para el desarrollo y pruebas rápidas.
   - **Consideraciones**:
     - Ideal para pruebas y desarrollo, pero no recomendable para entornos de producción.
     - Los datos se almacenan en memoria, por lo que no persisten entre reinicios de la aplicación.

### 5. **Spring Boot DevTools (Runtime)**
   - Herramienta que agiliza el desarrollo al permitir recargar la aplicación automáticamente cuando se detectan cambios en el código.
   - **Consideraciones**:
     - Útil únicamente en el entorno de desarrollo, mejora la productividad al reducir el tiempo necesario para ver los cambios en la aplicación.

## Requisitos Previos

- **Java 21**: Este proyecto está configurado para utilizar Java 21.
- **Maven**: Utilizado como herramienta de gestión de dependencias y construcción del proyecto.
