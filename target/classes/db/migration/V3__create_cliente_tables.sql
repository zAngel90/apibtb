-- Crear tabla de clientes
CREATE TABLE winners.clientes (
    legajo_numero BIGINT PRIMARY KEY,
    clipro CHARACTER(2) NOT NULL DEFAULT 'CL',
    razon_social VARCHAR(100),
    nombre_fantasia VARCHAR(100),
    documento_tipo VARCHAR(20),
    documento_numero VARCHAR(20),
    direccion VARCHAR(100),
    localidad VARCHAR(100),
    codigo_postal VARCHAR(20),
    telefono VARCHAR(50),
    email VARCHAR(100),
    activo BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear tabla de sucursales
CREATE TABLE winners.cliente_sucursales (
    id BIGSERIAL PRIMARY KEY,
    legajo_numero BIGINT NOT NULL REFERENCES winners.clientes(legajo_numero) ON DELETE CASCADE,
    codigo_sucursal INTEGER,
    nombre VARCHAR(100),
    direccion VARCHAR(100),
    localidad VARCHAR(100),
    codigo_postal VARCHAR(20),
    telefono VARCHAR(50),
    email VARCHAR(100),
    activo BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(legajo_numero, codigo_sucursal)
); 