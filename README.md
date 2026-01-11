# Sistema de Reservas API (Booking System)

API RESTful desarrollada con **Spring Boot 3** para la gestión integral de reservas y clientes. Este proyecto implementa una arquitectura en capas, principios SOLID y buenas prácticas del desarrollo Backend.

## Tecnologías Utilizadas

* **Lenguaje:** Java 25
* **Framework:** Spring Boot 3 (Maven)
* **Base de Datos:** MySQL 8
* **ORM:** Hibernate / JPA
* **Documentación:** OpenAPI (Swagger)

## Funcionalidades Principales

* **Gestión de Clientes:** CRUD completo.
* **Gestión de Reservas:** Creación de reservas vramainculadas a clientes existentes.
* **Validaciones:** Control de duplicados a través de comparaciones de email único y manejo de errores personalizados (APIResponse y ResponseUtil).
* **Arquitectura:** Diseño escalable basado en capas (Controller, Service, Repository y Entity).

## Diagrama de Entidad-Relación de las entidades
![Diagrama Entidad-Relación.](https://imgur.com/a/PfDDANh)

## Configuración y Ejecución

### Prerrequisitos
1. Tener instalado Java JDK 21 o posterior.
2. Tener el servidor MySQL ejecutando (por ejemplo, en XAMPP).

### Pasos
1.  Clonar el repositorio:
    ```bash
    git clone https://github.com/Nico96DC/Sistema-de-Reservas---API-RESTful.git
    ```
2.  Crear una base de datos vacía en MySQL llamada `systemBooking_db`.
3.  Configurar el archivo `src/main/resources/application.properties` con el usuario y la contraseña de MySQL.
4.  Ejecutar la aplicación desde IntelliJ IDEA o desde la consola, con el comando:
    ```bash
    mvn spring-boot:run
    ```
<!--
## Documentación API (Swagger)

Una vez iniciada la aplicación, se puede probar todos los endpoints de forma interactiva sin necesidad de Postman, visitando:

**[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**
-->
