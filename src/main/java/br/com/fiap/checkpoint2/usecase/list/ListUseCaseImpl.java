package br.com.fiap.checkpoint2.usecase.list;

import br.com.fiap.checkpoint2.entity.Pedido;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.infrastructure.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListUseCaseImpl implements ListUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<PedidoOutputDTO> execute() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();

        List<PedidoOutputDTO> pedidosDto = pedidos
                .stream()
                .map(product -> modelMapper.map(product, PedidoOutputDTO.class))
                .collect(Collectors.toList());

        return pedidosDto;
    }

}
