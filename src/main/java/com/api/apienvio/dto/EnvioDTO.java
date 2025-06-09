package com.api.apienvio.dto;

import lombok.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnvioDTO {
    private Integer IdEnvio;
    private Date FechaEnvio;
    private String direccion;
    private String EstadoEnvio;
}
