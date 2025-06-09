package com.api.apienvio.services;

import com.api.apienvio.repository.EnvioRepository;
import com.api.apienvio.dto.EnvioDTO;
import com.api.apienvio.models.Envio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class EnvioServices {

    @Autowired
    private EnvioRepository enviorepository;
    private EnvioDTO toDTO(Envio envio) {
        return new EnvioDTO(
            envio.getIdEnvio(),
            envio.getFechaEnvio(),
            envio.getDireccion(),
            envio.getEstadoEnvio()
        );
    }

    private Envio toEntity(EnvioDTO dto) {
        Envio envio = new Envio();
        envio.setIdEnvio(dto.getIdEnvio());
        envio.setFechaEnvio(dto.getFechaEnvio());
        envio.setDireccion(dto.getDireccion());
        envio.setEstadoEnvio(dto.getEstadoEnvio());
        return envio;
    }
    

    public EnvioDTO crear (EnvioDTO dto) {
        Envio envio = toEntity(dto);
        return toDTO(enviorepository.save(envio));
    }

    public List<EnvioDTO> listar() {
        return enviorepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public EnvioDTO buscar(Integer id) {
        Envio envio = enviorepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Envio no encontrado"));
        return toDTO(envio);
    }

    public EnvioDTO actualizar(Integer id, EnvioDTO dto) {
        Envio existente = enviorepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Envio no encontrado"));
        existente.setFechaEnvio(dto.getFechaEnvio());
        existente.setDireccion(dto.getDireccion());
        existente.setEstadoEnvio(dto.getEstadoEnvio());
        return toDTO(enviorepository.save(existente));
    }

    public void eliminar(Integer id) {
        enviorepository.deleteById(id);
    }
}
