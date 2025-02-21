# API Winners

API REST desarrollada con Spring Boot para la gestión de datos empresariales.

## Requisitos Previos

- Java JDK 17 o superior
- Maven 3.6 o superior
- PostgreSQL 12 o superior

## Configuración

### Base de Datos

La aplicación está configurada para conectarse a una base de datos PostgreSQL. Los parámetros de conexión se encuentran en `src/main/resources/application.properties`:

```properties
core.datasource.url=jdbc:postgresql://[host]:[puerto]/DatosBTB?currentSchema=winners
core.datasource.username=[usuario]
core.datasource.password=[contraseña]
```

### Compilación y Ejecución

1. Clonar el repositorio:
```bash
git clone [url-del-repositorio]
```

2. Navegar al directorio del proyecto:
```bash
cd api-winners
```

3. Compilar el proyecto:
```bash
mvn clean install
```

4. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

La aplicación se ejecutará en el puerto 8088 por defecto.

## Documentación de la API

La documentación completa de la API está disponible a través de Swagger UI:

- Swagger UI: `http://localhost:8088/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8088/v3/api-docs`

### Endpoints Disponibles

#### Autenticación
- POST `/auth/login` - Iniciar sesión
- POST `/auth/refresh-token` - Renovar token JWT

#### Clientes
- GET `/api/btb/clientes` - Listar todos los clientes (paginado)
- GET `/api/btb/clientes/{legajoNumero}` - Obtener cliente por legajo
- GET `/api/btb/clientes/buscar` - Buscar cliente por documento
- POST `/api/btb/clientes` - Crear nuevo cliente

#### Productos
- GET `/api/btb/productos` - Listar todos los productos (paginado)
- GET `/api/btb/productos/{codigo}` - Obtener producto por código

#### Stock
- GET `/api/btb/stock` - Consultar stock de productos
- GET `/api/btb/stock/{producto}/{deposito}` - Consultar stock específico

#### Pedidos
- GET `/api/btb/pedidos` - Listar todos los pedidos
- GET `/api/btb/pedidos/{empresa}/{nroOperacion}/{renglon}` - Obtener pedido específico
- POST `/api/btb/pedidos` - Crear nuevo pedido

#### Facturas
- GET `/api/btb/facturas` - Listar todas las facturas
- GET `/api/btb/facturas/{id}` - Obtener factura específica
- POST `/api/btb/facturas` - Crear nueva factura

#### Cuentas Corrientes
- GET `/api/btb/cuentas-corrientes` - Consultar cuentas corrientes
- GET `/api/btb/cuentas-corrientes/{id}` - Obtener cuenta corriente específica

#### Costos
- GET `/api/btb/costos` - Consultar costos de productos
- GET `/api/btb/costos/{id}` - Obtener costo específico

#### Listas de Precios
- GET `/api/btb/listas-precios` - Listar todas las listas de precios
- GET `/api/btb/listas-precios/{id}` - Obtener lista de precios específica
- POST `/api/btb/listas-precios` - Crear nueva lista de precios

## Seguridad

La API utiliza JWT (JSON Web Tokens) para la autenticación. Para acceder a los endpoints protegidos:

1. Obtener token mediante `/auth/login`
2. Incluir el token en el header de las peticiones:
```
Authorization: Bearer [token]
```

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── org/com/ar/api/
│   │       ├── btb/
│   │       │   ├── config/
│   │       │   ├── controller/
│   │       │   ├── dto/
│   │       │   ├── entities/
│   │       │   ├── mapper/
│   │       │   ├── repositories/
│   │       │   └── services/
│   │       ├── core/
│   │       └── security/
│   └── resources/
│       ├── db/migration/
│       └── application.properties
```

## Base de Datos

El esquema de base de datos incluye las siguientes tablas principales:

- `clientes` - Información de clientes
- `productos` - Catálogo de productos
- `stock` - Control de inventario
- `pedidos` - Gestión de pedidos
- `facturas` - Facturación
- `cuentas_corrientes` - Cuentas corrientes de clientes
- `costos` - Costos de productos
- `listas_precios` - Listas de precios

## Características

- Arquitectura REST
- Documentación con OpenAPI 3.0
- Autenticación JWT
- Paginación de resultados
- Manejo de errores centralizado
- Logging configurable
- Migración de base de datos con Flyway
- DTOs para transferencia de datos
- Mappers con MapStruct

## Soporte

Para reportar problemas o solicitar nuevas características, por favor crear un issue en el repositorio.
            
            
            
            

        