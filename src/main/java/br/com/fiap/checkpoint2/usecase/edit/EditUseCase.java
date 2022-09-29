package br.com.fiap.checkpoint2.usecase.edit;

import br.com.fiap.checkpoint2.infrastructure.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;

public interface EditUseCase {

    PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO, Long id);
}
