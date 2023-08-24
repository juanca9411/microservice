package com.microservice.domain.model.client;

import com.microservice.domain.model.commond.exception.BusinessException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

import static com.microservice.domain.model.commond.StringUtils.isNumberFormat;

@Getter
@Setter
@ToString
public class Client {
    private static final String REQUIRED_DOCUMENT_TYPE = "required document type";
    private static final String REQUIRED_DOCUMENT_NUMBER = "required document number";
    private static final String INVALID_DOCUMENT_TYPE = "invalid document type";
    private static final String INVALID_DOCUMENT_NUMBER = "invalid document number";

    public enum DocumentType {C, P}

    private String documentType;
    private String documentNumber;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer telefono;
    private String direccion;
    private String ciudadReidencia;

    public Client(String documentType, String documentNumber) {
        validateRequiredData(documentType, documentNumber);
        validateFormatInformation(documentType, documentNumber);
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    private void validateRequiredData(String documentType, String documentNumber) {
        if (Objects.isNull(documentType) || documentType.isEmpty()) {
            throw new BusinessException(REQUIRED_DOCUMENT_TYPE);
        }
        if (Objects.isNull(documentNumber) || documentNumber.isEmpty()) {
            throw new BusinessException(REQUIRED_DOCUMENT_NUMBER);
        }
    }

    private void validateFormatInformation(String documentType, String documentNumber) {
        if (!documentType.equalsIgnoreCase(DocumentType.C.toString()) &&
                !documentType.equalsIgnoreCase(DocumentType.P.toString())) {
            throw new BusinessException(INVALID_DOCUMENT_TYPE);
        }

        if (!isNumberFormat(documentNumber)) {
            throw new BusinessException(INVALID_DOCUMENT_NUMBER);
        }
    }

}
