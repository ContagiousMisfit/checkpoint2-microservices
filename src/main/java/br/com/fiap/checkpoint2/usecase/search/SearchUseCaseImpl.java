package br.com.fiap.checkpoint2.usecase.search;

import br.com.fiap.checkpoint2.entity.Pedido;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.infrastructure.exception.DatabaseFieldException;
import br.com.fiap.checkpoint2.infrastructure.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchUseCaseImpl implements SearchUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoOutputDTO execute(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new DatabaseFieldException("id", "not found"));
        ModelMapper modelMapper = new ModelMapper();
        PedidoOutputDTO pedidoOutputDTO = modelMapper.map(pedido, PedidoOutputDTO.class);
        return pedidoOutputDTO;
    }

}
