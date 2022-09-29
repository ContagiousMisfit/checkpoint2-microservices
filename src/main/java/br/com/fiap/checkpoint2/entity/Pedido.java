package br.com.fiap.checkpoint2.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant dataPedido;

    @Column(nullable = false)
    private Long codigoCliente;

    @Column(nullable = false)
    private Instant dataCadastro;

    @Column(nullable = false)
    private BigDecimal valorTotal;

}
