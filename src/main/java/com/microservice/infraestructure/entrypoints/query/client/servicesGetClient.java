package com.microservice.infraestructure.entrypoints.query.client;

import com.microservice.domain.model.client.dto.ClientDto;
import com.microservice.domain.usecase.UseCaseGetClientByTypeAndDocumentNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class servicesGetClient {
    @Autowired
    UseCaseGetClientByTypeAndDocumentNumber useCase;

    @GetMapping(value = "/client/document")
    public ClientDto getClient(@RequestParam String documentType,
                               @RequestParam String documentNumber) {
        return useCase.getClient(documentType,documentNumber);
    }
}
