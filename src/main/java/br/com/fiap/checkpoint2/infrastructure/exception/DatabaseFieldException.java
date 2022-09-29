package br.com.fiap.checkpoint2.infrastructure.exception;

import lombok.Getter;

@Getter
public class DatabaseFieldException extends RuntimeException {

    private final String name;

    public DatabaseFieldException(String name, String message) {
        super(message);
        this.name = name;
    }
}
