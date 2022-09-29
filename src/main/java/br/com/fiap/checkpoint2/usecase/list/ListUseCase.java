package br.com.fiap.checkpoint2.usecase.list;

import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;

import java.util.List;

public interface ListUseCase {
    List<PedidoOutputDTO> execute();
}
