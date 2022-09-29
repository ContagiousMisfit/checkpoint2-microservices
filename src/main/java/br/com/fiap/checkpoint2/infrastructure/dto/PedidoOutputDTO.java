package br.com.fiap.checkpoint2.infrastructure.dto;

import br.com.fiap.checkpoint2.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoOutputDTO {

    private Instant dataPedido;

    private Long codigoCliente;

    private Instant dataCadastro;

    private BigDecimal valorTotal;

    public PedidoOutputDTO(Pedido pedido) {
        this.dataPedido = pedido.getDataPedido();
        this.codigoCliente = pedido.getCodigoCliente();
        this.dataCadastro = pedido.getDataCadastro();
        this.valorTotal = pedido.getValorTotal();
    }
}