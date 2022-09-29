package br.com.fiap.checkpoint2.infrastructure.controller.handler;

import br.com.fiap.checkpoint2.infrastructure.dto.error.ErrorMessage;
import br.com.fiap.checkpoint2.infrastructure.dto.error.ErrorResponse;
import br.com.fiap.checkpoint2.infrastructure.exception.DatabaseFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DatabaseFieldException.class)
    public ErrorResponse handleDatabaseFieldExceptions(DatabaseFieldException ex) {

        ErrorResponse errorResponse = new ErrorResponse();

        String path = ex.getName();
        String message = ex.getMessage();
        errorResponse.getErrors().add(new ErrorMessage(path, message));

        return errorResponse;

    }

}
