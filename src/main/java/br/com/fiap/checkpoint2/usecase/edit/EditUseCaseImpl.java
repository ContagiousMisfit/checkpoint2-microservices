package br.com.fiap.checkpoint2.usecase.edit;

import br.com.fiap.checkpoint2.entity.Pedido;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.infrastructure.exception.DatabaseFieldException;
import br.com.fiap.checkpoint2.infrastructure.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditUseCaseImpl implements EditUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO, Long id) {
        Pedido pedidoEditado = edit(pedidoRepository, id, pedidoInputDTO);
        return new PedidoOutputDTO(pedidoEditado);
    }

    public Pedido edit(PedidoRepository pedidoRepository, Long id, PedidoInputDTO pedidoInputDTO) {
        Pedido pedidoEditado = pedidoRepository.findById(id).orElseThrow(() -> new DatabaseFieldException("pedido", "não encontrado."));
        pedidoEditado.setDataPedido(pedidoInputDTO.getDataPedido());
        pedidoEditado.setCodigoCliente(pedidoInputDTO.getCodigoCliente());
        pedidoEditado.setDataCadastro(pedidoInputDTO.getDataCadastro());
        pedidoEditado.setValorTotal(pedidoInputDTO.getValorTotal());
        pedidoRepository.save(pedidoEditado);
        return pedidoEditado;
    }
}
