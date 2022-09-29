package br.com.fiap.checkpoint2.usecase.insert;

import br.com.fiap.checkpoint2.entity.Pedido;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.infrastructure.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertUseCaseImpl implements InsertUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO) {

        Pedido pedido = pedidoInputDTO.convert(pedidoRepository);
        pedidoRepository.save(pedido);
        return new PedidoOutputDTO(pedido);
    }
}
