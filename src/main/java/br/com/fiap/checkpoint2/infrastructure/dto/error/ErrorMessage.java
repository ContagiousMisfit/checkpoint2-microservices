package br.com.fiap.checkpoint2.infrastructure.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String path;
    private String message;

}
