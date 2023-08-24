package com.microservice.infraestructure.drivenadapter.mock.repository.query.client;

import com.microservice.domain.model.client.dto.ClientDto;
import com.microservice.domain.model.client.repository.ClientRepository;
import com.microservice.domain.model.commond.exception.NotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ClientQueryMockAdapterRepository implements ClientRepository {

    private static final String DOCUMENT_TYPE_FOR_DEFAULT = "C";
    private static final String DOCUMNET_NUMBER_FOR_DEFAULT = "23445322";
    private static final String PRIMER_NOMBRE = "Juan";
    private static final String SEGUNDO_NOMBRE = "Pepito";
    private static final String PRIMER_APELLIDO = "Perez";
    private static final String SEGUNDO_APELLIDO = "Castro";
    private static final int TELEFONO = 6054756;
    private static final String DIRECCION = "Colombia, Cartagena bolivar";
    private static final String CIUDAD_REIDENCIA = "Cartagena";
    private static final String CLIENT_NOT_FOUND = "Client Not Found";

    @Override
    public ClientDto getClientByTypeAndDocumentNumber(String documentType, String documentNumber) {
        if (documentType.equalsIgnoreCase(DOCUMENT_TYPE_FOR_DEFAULT) && documentNumber.equals(DOCUMNET_NUMBER_FOR_DEFAULT)){
            return new ClientDto(
                    PRIMER_NOMBRE,
                    SEGUNDO_NOMBRE,
                    PRIMER_APELLIDO,
                    SEGUNDO_APELLIDO,
                    TELEFONO,
                    DIRECCION,
                    CIUDAD_REIDENCIA
                    );
        }
        throw new NotFoundException(CLIENT_NOT_FOUND);
    }
}
