package br.com.fiap.checkpoint2.infrastructure.repository;

import br.com.fiap.checkpoint2.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
