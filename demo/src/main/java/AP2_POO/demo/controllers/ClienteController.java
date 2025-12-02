package AP2_POO.demo.controllers;


import AP2_POO.demo.DTO.ClienteRequest;
import AP2_POO.demo.DTO.ClienteResponse;
import AP2_POO.demo.models.Cliente;
import AP2_POO.demo.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ClienteRequest cliente){

        try {
            ClienteResponse result = clienteService.criarCliente(cliente);

            if (result != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso.");
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar usuário.");

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll(){
        List<ClienteResponse> result = clienteService.buscarClientes();

        if (!result.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getById(@PathVariable int id){

        ClienteResponse cliente = clienteService.buscarCliente(id);

        if (cliente != null){
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody ClienteRequest cliente){
        ClienteResponse clienteResponse = clienteService.atualizarCliente(id,cliente);

        if (clienteResponse != null){
            return ResponseEntity.status(HttpStatus.OK).body("Cliente Atualizado com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha ao atualizar cliente.");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        String response = clienteService.deletarCliente(id);

        if (response.equals("sucesso")){
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }

}
