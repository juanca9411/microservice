package com.microservice.domain.usecase;

import com.microservice.domain.model.client.Client;
import com.microservice.domain.model.client.dto.ClientDto;
import com.microservice.domain.model.client.repository.ClientRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UseCaseGetClientByTypeAndDocumentNumber {
    final ClientRepository clientRepository;
    public ClientDto getClient(String documentType, String documentNumber) {
        Client client = new Client(documentType,documentNumber);
        return clientRepository.getClientByTypeAndDocumentNumber(client.getDocumentType(), client.getDocumentNumber());
    }
}
