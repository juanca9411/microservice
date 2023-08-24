package com.microservice.application.config;

import com.microservice.domain.model.client.repository.ClientRepository;
import com.microservice.domain.usecase.UseCaseGetClientByTypeAndDocumentNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public UseCaseGetClientByTypeAndDocumentNumber consultarProyecto(ClientRepository repository) {
        return new UseCaseGetClientByTypeAndDocumentNumber(repository);
    }




}
