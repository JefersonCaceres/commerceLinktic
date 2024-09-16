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
 #  El proyecto está dividido en las siguientes capas:
*   Configuration: Este paquete contiene las clases de configuración, como la clase SecurityConfig, donde se define la seguridad de la          aplicación y se manejan las reglas de acceso. También incluye una clase de manejo de errores centralizada, como el handler de excepciones, que gestiona los errores de la aplicación.
*   entity: En este paquete se encuentran todas las entidades del modelo de datos que representan las tablas de la base de datos. Cada entidad corresponde a un objeto del dominio del negocio.
*   Controladores (Controllers): Los controladores son responsables de manejar las peticiones HTTP entrantes, mapearlas a las acciones correspondientes y devolver las respuestas apropiadas. Aquí es donde se implementa la lógica de manejo de rutas y solicitudes de la API.
*   Servicios (Services): Los servicios contienen la lógica de negocio.
*   Repositorio (Repository): Aquí es donde se manejan las interacciones con la base de datos utilizando JPA.
*   model: Este paquete incluye los DTOs (Data Transfer Objects) de respuesta. Los DTOs son objetos que se utilizan para enviar datos entre el servidor y el cliente, proporcionando una abstracción que permite controlar los datos que se exponen a través de la API.
*   util: El paquete utilitario contiene herramientas y componentes auxiliares. En particular, en este proyecto se encarga de manejar la autenticación basada en JWT (JSON Web Token). Aquí es donde reside la lógica relacionada con la generación, validación y manejo de tokens JWT.
*   mapper: Este paquete se encarga del mapeo entre las entidades del modelo y los DTOs. El mapeo permite transformar entidades persistentes en objetos de transferencia (DTOs) y viceversa, facilitando la comunicación entre las diferentes capas de la aplicación.
*   error: En este paquete se maneja el control de errores y excepciones. Aquí se define la lógica que gestiona y formatea los mensajes de error, asegurando que las respuestas de error sean coherentes y adecuadas para las solicitudes.

# 4. Instalación y Configuración
*   Prerrequisitos
    Asegúrate de tener las siguientes herramientas instaladas en tu sistema:

    *   Java 21
    *   Maven
    *   Un IDE compatible con Java (IntelliJ, Eclipse, etc.)
# Pasos para la Instalación
1. Clona el repositorio del proyecto:
    -   git clone https://github.com/JefersonCaceres/commerceLinktic.git
2. con el IDE abre el proyecto
    -   commerceLinktic
3. Compila el proyecto utilizando Maven: 
    -   mvn clean install
4. Ejecuta la aplicación:
    -   mvn spring-boot:run
La aplicación estará disponible en http://localhost:8000/

# 5. Endpoints de la API
*   Login
    -   Para poder interactuar con los demás endpoints de la API, es necesario autenticarse primero y obtener un token JWT. Este token se usará en el encabezado de todas las solicitudes protegidas.(en este caso son todos los endpoint a excepcion del login)
    *   URL: http://localhost:8000/login
    *   Metodo: POST
    *   Descripción: Autenticación del usuario, genera un token JWT.
    *   Body (JSON): { "username": "admin","password": "admin"}
    *   Respuesta: Devuelve el token JWT que se utilizará en los siguientes endpoints para autenticación.
    *    copia ese token ya que lo usaremos para poder autentificar la peticion
    *   abrimos cualquier endpoint nos vamos a la pestaña llamada Authorization
    *   en Auth type buscamos bearer token y ahi pegamos el Token de esa manera podemos usar las peticiones
# La coleccion de postman la dejare en el proyecto, \src\main\postman aqui encontraran una coleccion con todos los endpoint 

# 6. BASE DE DATOS  
    -   El proyecto utiliza una base de datos H2 en memoria para almacenar los datos relacionados con los productos, órdenes y usuarios. A continuación, se describen las tablas, su estructura y los datos iniciales cargados en la base de datos mediante los archivos schema.sql y data.sql.

*   La tabla product almacena información sobre los productos disponibles en la tienda.

    *   id: Identificador único del producto. (Clave primaria, autoincremental)
    *   name: Nombre del producto.
    *   cost: Costo del producto.
    *   stock: Cantidad disponible en inventario.

*   La tabla orders almacena información sobre las órdenes realizadas.

    *   id: Identificador único de la orden. (Clave primaria, autoincremental)
    *   order_date: Fecha y hora en que se realizó la orden.
    *   total: Monto total de la orden.

*   La tabla order_item almacena los productos incluidos en cada orden.

    *   id: Identificador único del ítem de la orden. (Clave primaria, autoincremental)
    *   order_id: Referencia a la orden. (Clave foránea que apunta a orders.id)
    *   product_id: Referencia al producto. (Clave foránea que apunta a product.id)
    *   amount: Cantidad del producto en la orden.
    *   total: Costo total del ítem en la orden.

*   La tabla users almacena la información de los usuarios del sistema.

    *   username: Nombre de usuario único. (Clave primaria)
    *   password: Contraseña encriptada del usuario.
    *   role: Rol del usuario (por ejemplo, ADMIN o USER).

# 7. Inicialización Automática de la Base de Datos
En el proyecto Commerce, la base de datos se inicializa automáticamente en cada despliegue utilizando los archivos schema.sql y data.sql. Este proceso asegura que las tablas y los datos necesarios estén disponibles en la base de datos H2 (en memoria) sin necesidad de intervención manual.

*   7.1. Archivos de Inicialización
    *    schema.sql
    - Este archivo contiene las sentencias SQL que crean las tablas necesarias en la base de datos. Es ejecutado automáticamente por Spring Boot al iniciar la aplicación.

   *    data.sql
    -   El archivo data.sql contiene datos de ejemplo (productos, órdenes, ítems de órdenes y usuarios) que son insertados automáticamente cada vez que la aplicación se despliega. Esto es útil para pruebas y desarrollo, ya que proporciona un conjunto básico de datos con los que trabajar desde el primer momento.

