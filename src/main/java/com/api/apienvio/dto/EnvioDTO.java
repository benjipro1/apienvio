package com.api.apienvio.dto;

import lombok.*;
import java.sql.Date;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnvioDTO extends RepresentationModel<EnvioDTO> {
    private Integer IdEnvio;
    private Date FechaEnvio;
    private String direccion;
    private String EstadoEnvio;
}
