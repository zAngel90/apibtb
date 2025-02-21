# API BTB (Back To Business)

API REST desarrollada con Spring Boot para la gestión de datos empresariales. Proporciona endpoints para manejar clientes, facturas, productos, stock y más.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI 3.0
- Maven

## Requisitos Previos

- Java JDK 17 o superior
- Maven 3.6 o superior
- PostgreSQL 12 o superior
- Git

## Configuración del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/zAngel90/apibtb.git
cd apibtb
```

### 2. Configuración de Base de Datos

La aplicación está configurada para conectarse a PostgreSQL. Configura los parámetros de conexión en `src/main/resources/application.properties`:

```properties
core.datasource.url=jdbc:postgresql://[host]:[puerto]/DatosBTB?currentSchema=winners
core.datasource.username=[usuario]
core.datasource.password=[contraseña]
core.datasource.driver-class-name=org.postgresql.Driver
```

### 3. Compilación y Ejecución

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

La aplicación se ejecutará en: `http://localhost:8088`

## Documentación de la API

### Acceso a Swagger UI

- **Swagger UI**: `http://localhost:8088/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8088/v3/api-docs`

### Endpoints Principales

#### Autenticación
- `POST /auth/login` - Iniciar sesión
- `POST /auth/refresh-token` - Renovar token JWT

#### Gestión de Facturas
- `GET /api/btb/facturas` - Listar todas las facturas
- `GET /api/btb/facturas/{empresa}/{nroOperacion}` - Obtener factura por ID
- `POST /api/btb/facturas` - Crear nueva factura
- `PUT /api/btb/facturas/{empresa}/{nroOperacion}` - Actualizar factura
- `DELETE /api/btb/facturas/{empresa}/{nroOperacion}` - Eliminar factura
- `PATCH /api/btb/facturas/{empresa}/{nroOperacion}/anular` - Anular factura
- `PATCH /api/btb/facturas/{empresa}/{nroOperacion}/cancelar` - Cancelar factura

#### Gestión de Clientes
- `GET /api/btb/clientes` - Listar todos los clientes
- `GET /api/btb/clientes/{legajo}` - Obtener cliente por legajo
- `GET /api/btb/clientes/sucursales` - Obtener sucursales de clientes

#### Gestión de Productos
- `GET /api/btb/productos` - Listar todos los productos
- `GET /api/btb/productos/{sku}` - Obtener producto por SKU

#### Gestión de Stock
- `GET /api/btb/stock` - Consultar stock
- `GET /api/btb/stock/{producto}/{deposito}` - Consultar stock específico

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── org/com/ar/api/
│   │       ├── btb/
│   │       │   ├── controller/    # Controladores REST
│   │       │   ├── dto/          # Objetos de transferencia de datos
│   │       │   ├── entities/     # Entidades JPA
│   │       │   ├── mapper/       # Mappers para conversión de objetos
│   │       │   ├── repository/   # Repositorios JPA
│   │       │   └── service/      # Lógica de negocio
│   │       ├── core/            # Configuraciones core
│   │       └── security/        # Configuración de seguridad
│   └── resources/
│       ├── db/migration/        # Scripts de migración Flyway
│       └── application.properties
```

## Seguridad

La API utiliza JWT (JSON Web Tokens) para la autenticación. Para acceder a los endpoints protegidos:

1. Obtener token mediante `/auth/login`
2. Incluir el token en el header de las peticiones:
```
Authorization: Bearer [token]
```

## Características Principales

- Arquitectura REST
- Documentación con OpenAPI 3.0
- Autenticación JWT
- Paginación de resultados
- Manejo de errores centralizado
- Logging configurable
- Migración de base de datos con Flyway
- DTOs para transferencia de datos
- Mappers con MapStruct

## Entidades Principales

### Factura
- Gestión completa de facturas
- Soporte para diferentes tipos de comprobantes
- Manejo de estados (anulada, cancelada)
- Relación con clientes y productos

### Cliente
- Gestión de datos de clientes
- Manejo de sucursales
- Información fiscal y comercial

### Producto
- Catálogo de productos
- Gestión de precios
- Control de stock

### Stock
- Control de inventario
- Múltiples depósitos
- Tracking de movimientos

## Soporte y Contribución

Para reportar problemas o sugerir mejoras, por favor crear un issue en el repositorio de GitHub.

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.
            
            
            
            

        