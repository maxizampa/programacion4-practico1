# Ejercicio 1: API de Gestión de Menú (Delivery)

Este proyecto es el **Trabajo Practico Nº 1** de la cátedra de **Programación IV**. Se trata de una API REST desarrollada con **Java** y **Spring Boot** para gestionar los platos de un sistema de delivery, utilizando una arquitectura de capas y persistencia en memoria.


## Tecnologías y Herramientas
* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3.x
* **Gestor de Dependencias:** Maven
* **Libreroas Auxiliares:** * **Lombok**: Para la generación automática de Getters y Setters.
    * **SpringDoc OpenAPI (Swagger)**: Para la documentacion técnica interactiva, agregada despues

---

## Arquitectura
 **Arquitectura en Capas**, separando las responsabilidades para facilitar el mantenimiento y testeo:

| Capa | Responsabilidad |
| :--- | :--- |
| **Controller** | Punto de entrada de la API Recibe las peticiones HTTP y define las rutas. 
| **Service** |  Contiene toda la logica de negocio y validaciones. 
| **Repository** | Encargado de interactuar con el almacenamiento de datos
| **Model** | modelo que define los atributos de la entidad `Plato`. 

---

## Validaciones de Negocio Implementadas
Para asegurar la calidad de los datos, el **PlatoService** realiza los siguientes controles antes de guardar:
* **Integridad de ID:** No se permiten duplicados del `numeroPlato`.
* **Nombre Único:** Se valida mediante un bucle que no existan dos platos con el mismo nombre (ignora mayúsculas/minúsculas).
* **Campos Obligatorios:** Verificación de presencia de nombre, número y precio.
* **Consistencia de Precio:** El valor debe ser estrictamente mayor a cero.
* **Largo de Descripción:** Límite de 200 caracteres para mantener la brevedad solicitada.


##  Detalle de Endpoints
| Metodo | Endpoint | Accion |
| :--- | :--- | :--- |
| **POST** | `/platos` | Crea un nuevo plato (Enviar JSON en el Body). |
| **GET** | `/platos` | Retorna la lista con todos los platos registrados. |
| **GET** | `/platos/{id}` | Busca y retorna un plato por su número identificador. |

---

### Autor
* **Maximiliano Zampa** - Estudiante de Programación IV - **UTN**
