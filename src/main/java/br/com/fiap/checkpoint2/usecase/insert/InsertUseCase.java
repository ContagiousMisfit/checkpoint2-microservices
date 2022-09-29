package br.com.fiap.checkpoint2.usecase.insert;


import br.com.fiap.checkpoint2.infrastructure.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;

public interface InsertUseCase {

    PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO);
}
