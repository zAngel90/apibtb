CREATE TABLE winners.usuario (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE winners.usuario_rol (
    usuario_id BIGINT REFERENCES winners.usuario(id),
    rol VARCHAR(50) NOT NULL,
    PRIMARY KEY (usuario_id, rol)
);

-- Insertar un usuario administrador por defecto
INSERT INTO winners.usuario (username, password, enabled)
VALUES ('admin', '$2a$10$rJSMjr0Y/JSuX5CBz5/oceNpQPG9aD0oiDrw0LH1./.nxcRgRqnHu', true);

INSERT INTO winners.usuario_rol (usuario_id, rol)
VALUES (1, 'ROLE_ADMIN'); 