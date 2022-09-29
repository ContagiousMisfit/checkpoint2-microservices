package br.com.fiap.checkpoint2.infrastructure.dto.error;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {

    private List<ErrorMessage> errors = new ArrayList<>();

}
