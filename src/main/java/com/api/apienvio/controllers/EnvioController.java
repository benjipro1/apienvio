package com.api.apienvio.controllers;

import com.api.apienvio.dto.EnvioDTO;
import com.api.apienvio.models.Envio;
import com.api.apienvio.services.EnvioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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

    @GetMapping("/hateoas/{id}")
    public EnvioDTO obtenerHateoas(@PathVariable Integer id) {
        EnvioDTO dto = envioServices.buscar(id);
        dto.add(linkTo(methodOn(EnvioController.class).buscar(id)).withSelfRel());
        dto.add(linkTo(methodOn(EnvioController.class).listar()).withRel("TODOS"));
        dto.add(linkTo(methodOn(EnvioController.class).eliminar(id)).withRel("ELIMINAR"));
        return dto;
    }
    
    @GetMapping("/hateoas")
    public List<EnvioDTO> listarHateoas() {
        List<EnvioDTO> envios = envioServices.listar();
        for (EnvioDTO dto : envios) {
            dto.add(linkTo(methodOn(EnvioController.class).obtenerHateoas(dto.getIdEnvio())).withSelfRel());
        }
        return envios;
    }
}
