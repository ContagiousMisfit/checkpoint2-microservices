package br.com.fiap.checkpoint2.infrastructure.dto;

import br.com.fiap.checkpoint2.entity.Pedido;
import br.com.fiap.checkpoint2.infrastructure.repository.PedidoRepository;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;


@Data
public class PedidoInputDTO {

    @NotNull
    private Instant dataPedido;

    @NotNull
    @Size(min = 3, max = 5, message = "O código do cliente deve ter entre 3 e 5 dígitos.")
    private Long codigoCliente;

    @NotNull
    private Instant dataCadastro;

    @NotNull
    private BigDecimal valorTotal;

    public Pedido convert(PedidoRepository pedidoRepository) {
        return new Pedido().builder()
                .dataPedido(dataPedido)
                .codigoCliente(codigoCliente)
                .dataCadastro(dataCadastro)
                .valorTotal(valorTotal)
                .build();
    }


}
