package com.microservice.domain;

import com.microservice.domain.model.client.dto.ClientDto;
import com.microservice.domain.model.client.repository.ClientRepository;
import com.microservice.domain.model.commond.exception.BusinessException;
import com.microservice.domain.model.commond.exception.NotFoundException;
import com.microservice.domain.usecase.UseCaseGetClientByTypeAndDocumentNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UseCaseGetClientByTypeAndDocumentNumberTest {

    private static final String PRIMER_NOMBRE = "Juan";
    private static final String SEGUNDO_NOMBRE = "Pepito";
    private static final String PRIMER_APELLIDO = "Perez";
    private static final String SEGUNDO_APELLIDO = "Castro";
    private static final int TELEFONO = 6054756;
    private static final String DIRECCION = "Colombia, Cartagena bolivar";
    private static final String CIUDAD_REIDENCIA = "Cartagena";
    private static final String CLIENT_NOT_FOUND = "Client Not Found";


    @InjectMocks
    UseCaseGetClientByTypeAndDocumentNumber useCaseGetClientByTypeAndDocumentNumber;
    @Mock
    ClientRepository clientRepository;

    @Test
    void testGetClientSuccess(){
        ClientDto clientResponse = new ClientDto(
                PRIMER_NOMBRE,
                SEGUNDO_NOMBRE,
                PRIMER_APELLIDO,
                SEGUNDO_APELLIDO,
                TELEFONO,
                DIRECCION,
                CIUDAD_REIDENCIA
        );
        when(clientRepository.getClientByTypeAndDocumentNumber(anyString(),anyString())).thenReturn(clientResponse);

        String documentType = "C";
        String documentNumber = "123";
        var response = useCaseGetClientByTypeAndDocumentNumber.getClient(documentType,documentNumber);
        Assertions.assertEquals("Juan",response.getPrimerNombre());
    }

    @Test
    void testGetClientNotFound(){
        when(clientRepository.getClientByTypeAndDocumentNumber(anyString(),anyString())).thenThrow(new NotFoundException(CLIENT_NOT_FOUND));
        String documentType = "C";
        String documentNumber = "123";
        Assertions.assertThrows(NotFoundException.class,()->useCaseGetClientByTypeAndDocumentNumber.getClient(documentType,documentNumber));
    }

    @Test
    void testGetClientDocumentTypeRequired(){
        String documentType = null;
        String documentNumber = "123";
        Assertions.assertThrows(BusinessException.class,
                ()->useCaseGetClientByTypeAndDocumentNumber.getClient(documentType,documentNumber),"required document type");
    }

    @Test
    void testGetClientDocumentNumberRequired(){
        String documentType = "C";
        String documentNumber = null;
        Assertions.assertThrows(BusinessException.class,
                ()->useCaseGetClientByTypeAndDocumentNumber.getClient(documentType,documentNumber),"required document number");
    }

    @Test
    void testGetClientDocumentTypeInvalidFormat(){
        String documentType = "NIT";
        String documentNumber = "123";
        Assertions.assertThrows(BusinessException.class,
                ()->useCaseGetClientByTypeAndDocumentNumber.getClient(documentType,documentNumber),"invalid document type");
    }

    @Test
    void testGetClientDocumentNumberInvalidFormat(){
        String documentType = "P";
        String documentNumber = "123E";
        Assertions.assertThrows(BusinessException.class,
                ()->useCaseGetClientByTypeAndDocumentNumber.getClient(documentType,documentNumber),"invalid document number");
    }
}
