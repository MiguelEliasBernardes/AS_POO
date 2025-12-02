package AP2_POO.demo.controllers;


import AP2_POO.demo.DTO.PedidoRequest;
import AP2_POO.demo.DTO.PedidoResponse;
import AP2_POO.demo.models.Pedido;
import AP2_POO.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes/{clienteId}/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<String> create(@PathVariable int clienteId, @RequestBody PedidoRequest pedido){

        try {
            PedidoResponse result = pedidoService.criarPedido(clienteId,pedido);

            if (result != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado com sucesso.");
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar pedido.");

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> getAll(){
        List<PedidoResponse> result = pedidoService.buscarPedidos();

        if (!result.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<?> getById(@PathVariable int clienteId,  @PathVariable int pedidoId){

        try {
            PedidoResponse pedido = pedidoService.buscarPedido(pedidoId);

            if (pedido != null) {
                return ResponseEntity.status(HttpStatus.OK).body(pedido);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{pedidoId}")
    public ResponseEntity<String> update(@PathVariable long clienteId, @RequestBody PedidoRequest pedido, @PathVariable int pedidoId){
        PedidoResponse pedidoResponse = pedidoService.atualizarPedido(clienteId,pedido, pedidoId);

        if (pedidoResponse != null){
            return ResponseEntity.status(HttpStatus.OK).body("Pedido Atualizado com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha ao atualizar pedido.");

    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<String> delete(@PathVariable long clienteId, @PathVariable int pedidoId){
        boolean response = pedidoService.deletarPedido(pedidoId);

        if (response){
            return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }

}
