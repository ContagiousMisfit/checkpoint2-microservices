package br.com.fiap.checkpoint2.usecase.remove;

import br.com.fiap.checkpoint2.infrastructure.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveUseCaseImpl implements RemoveUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void execute(Long id) {
        pedidoRepository.deleteById(id);
    }

}
