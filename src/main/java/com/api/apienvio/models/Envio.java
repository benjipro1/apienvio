package com.api.apienvio.models;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "envios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "envios")
    private Integer IdEnvio;
    private Date FechaEnvio;
    private String direccion;
    private String EstadoEnvio;
}
