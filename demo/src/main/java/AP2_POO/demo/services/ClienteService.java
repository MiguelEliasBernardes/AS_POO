package AP2_POO.demo.services;

import AP2_POO.demo.DTO.ClienteRequest;
import AP2_POO.demo.DTO.ClienteResponse;
import AP2_POO.demo.models.Cliente;
import AP2_POO.demo.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponse criarCliente(ClienteRequest clienteRequest){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setTelefone(clienteRequest.getTelefone());

        Cliente salvo = clienteRepository.save(cliente);

        return new ClienteResponse(salvo);
    }

    public List<ClienteResponse> buscarClientes(){

        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(ClienteResponse::new)
                .toList();

    }

    public ClienteResponse buscarCliente(long id){

        try {
            Cliente cliente = clienteRepository.getById(id);

            return new ClienteResponse(cliente);

        }catch(Exception e){
            return null;
        }
    }

    public ClienteResponse atualizarCliente(long id, ClienteRequest cliente){

        Cliente clientefind = clienteRepository.getById(id);
        clientefind.setNome(cliente.getNome());
        clientefind.setTelefone(cliente.getTelefone());
        clienteRepository.save(clientefind);
        return new ClienteResponse(clientefind);

    }


    public String deletarCliente(long id){

        clienteRepository.deleteById(id);

        return "sucesso";
    }




}
