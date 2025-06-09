package com.api.apienvio.controllers;

import com.api.apienvio.dto.EnvioDTO;
import com.api.apienvio.services.EnvioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioServices envioServices;

    @PostMapping
    public ResponseEntity<EnvioDTO> crear(@RequestBody EnvioDTO dto) {
        return ResponseEntity.ok(envioServices.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<EnvioDTO>> listar() {
        return ResponseEntity.ok(envioServices.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(envioServices.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioDTO> actualizar(@PathVariable Integer id, @RequestBody EnvioDTO dto) {
        return ResponseEntity.ok(envioServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        envioServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
