package com.microservice.domain.model.client.repository;

import com.microservice.domain.model.client.dto.ClientDto;

public interface ClientRepository {
    ClientDto getClientByTypeAndDocumentNumber(String documentType, String documentNumber);
}
