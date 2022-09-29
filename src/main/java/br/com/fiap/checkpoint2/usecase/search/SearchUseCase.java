package br.com.fiap.checkpoint2.usecase.search;

import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;

public interface SearchUseCase {

    PedidoOutputDTO execute(Long id);
}
