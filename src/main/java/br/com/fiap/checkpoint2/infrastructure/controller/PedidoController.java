package br.com.fiap.checkpoint2.infrastructure.controller;

import br.com.fiap.checkpoint2.infrastructure.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.infrastructure.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.usecase.edit.EditUseCase;
import br.com.fiap.checkpoint2.usecase.insert.InsertUseCase;
import br.com.fiap.checkpoint2.usecase.list.ListUseCase;
import br.com.fiap.checkpoint2.usecase.remove.RemoveUseCase;
import br.com.fiap.checkpoint2.usecase.search.SearchUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private EditUseCase editUseCase;
    @Autowired
    private InsertUseCase insertUseCase;
    @Autowired
    private RemoveUseCase removeUseCase;
    @Autowired
    private ListUseCase listUseCase;
    @Autowired
    private SearchUseCase searchUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoOutputDTO> insertPedido(@RequestBody @Valid PedidoInputDTO pedidoInputDTO) {
        PedidoOutputDTO pedidoOutputDTO = insertUseCase.execute(pedidoInputDTO);
        return new ResponseEntity<>(pedidoOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoOutputDTO>> listPedidos() {
        List<PedidoOutputDTO> pedidos = listUseCase.execute();
        if (pedidos == null || pedidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoOutputDTO> searchPedidoById(@PathVariable Long id) {
        PedidoOutputDTO pedido = searchUseCase.execute(id);
        if (pedido == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoOutputDTO> editPedido(@RequestBody @Valid PedidoInputDTO pedidoInputDTO, @PathVariable Long id) {
        PedidoOutputDTO pedidoOutputDTO = editUseCase.execute(pedidoInputDTO, id);
        return new ResponseEntity<>(pedidoOutputDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removePedido(@PathVariable Long id) {
        removeUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
