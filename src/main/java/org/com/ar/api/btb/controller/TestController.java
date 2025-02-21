package org.com.ar.api.btb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/btb/test")
@Tag(name = "Test", description = "Endpoints para pruebas de conexión y verificación")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/conexion")
    @Operation(summary = "Probar conexión", description = "Verifica la conexión a la base de datos")
    public ResponseEntity<String> testConexion() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return ResponseEntity.ok("Conexión exitosa a la base de datos");
        } catch (Exception e) {
            log.error("Error al conectar a la base de datos: ", e);
            return ResponseEntity.status(500).body("Error de conexión: " + e.getMessage());
        }
    }

    @GetMapping("/verificar-tablas")
    @Operation(summary = "Verificar tablas", description = "Verifica la existencia de las tablas necesarias")
    public ResponseEntity<?> verificarTablas() {
        try {
            String query = """
                SELECT table_name, 
                       CASE WHEN table_name IS NOT NULL THEN true ELSE false END as exists 
                FROM information_schema.tables 
                WHERE table_schema = 'winners' 
                AND table_name IN ('clientes', 'cliente_sucursales')
                ORDER BY table_name;
            """;
            
            List<Map<String, Object>> resultado = jdbcTemplate.queryForList(query);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            log.error("Error al verificar tablas: ", e);
            return ResponseEntity.status(500).body("Error al verificar tablas: " + e.getMessage());
        }
    }

    @GetMapping("/listar-tablas")
    @Operation(summary = "Listar todas las tablas", description = "Lista todas las tablas del esquema winners")
    public ResponseEntity<?> listarTablas() {
        try {
            String query = """
                SELECT table_name 
                FROM information_schema.tables 
                WHERE table_schema = 'winners' 
                ORDER BY table_name;
            """;
            
            List<String> tablas = jdbcTemplate.queryForList(query, String.class);
            return ResponseEntity.ok(tablas);
        } catch (Exception e) {
            log.error("Error al listar tablas: ", e);
            return ResponseEntity.status(500).body("Error al listar tablas: " + e.getMessage());
        }
    }
} 