package com.microservice.domain.model.client.dto;

import lombok.Value;

@Value
public class ClientDto {
    String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    Integer telefono;
    String direccion;
    String ciudadReidencia;

}
