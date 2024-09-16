# commerceLinktic

# Documentación del Proyecto: Commerce
# 1. Descripción General
Commerce es una aplicación basada en Spring Boot diseñada como una plataforma de comercio electrónico. Utiliza una base de datos en memoria (H2) para facilitar el desarrollo y pruebas, junto con JWT para la autenticación de usuarios.

# 2. Tecnologías Utilizadas
*   Spring Boot 3.2.9: Framework principal para la construcción de la aplicación.
*   Spring Security: Utilizado para la autenticación y autorización de usuarios.
*   JSON Web Tokens (JWT): Para gestionar la autenticación basada en tokens.
*   H2 Database: Base de datos en memoria para el desarrollo y las pruebas.
*   JPA (Java Persistence API): Para el mapeo y la interacción con la base de datos.
*   Tomcat: Servidor web embebido.
*   Maven: Gestión de dependencias y construcción del proyecto.
# 3. Estructura del Proyecto
El proyecto está dividido en las siguientes capas:

Configuración de Seguridad: Implementada en la clase SecurityConfig, donde se define el acceso a los recursos y la configuración de JWT.
Filtros de Autenticación: El filtro JwtAuthenticationFilter gestiona la validación del token JWT y la autenticación del usuario.
Controladores (Controllers): Los controladores son responsables de manejar las peticiones HTTP y devolver respuestas adecuadas.
Servicios (Services): Los servicios contienen la lógica de negocio.
Repositorio (Repository): Aquí es donde se manejan las interacciones con la base de datos utilizando JPA.
