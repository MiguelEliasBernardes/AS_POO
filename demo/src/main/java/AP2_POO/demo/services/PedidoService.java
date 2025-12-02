package AP2_POO.demo.services;

import AP2_POO.demo.DTO.PedidoRequest;
import AP2_POO.demo.DTO.PedidoResponse;
import AP2_POO.demo.models.Cliente;
import AP2_POO.demo.models.Pedido;
import AP2_POO.demo.repositorys.ClienteRepository;
import AP2_POO.demo.repositorys.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoResponse criarPedido(long clienteId, PedidoRequest pedidoRequest){
       try{

            Cliente cliente = clienteRepository.findById(clienteId)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));;

            Pedido pedido = new Pedido();
            pedido.setPreco(pedidoRequest.getPreco());
            pedido.setQuantidade(pedidoRequest.getQuantidade());
            pedido.setNomeProduto(pedidoRequest.getNomeProduto());
            pedido.setCliente(cliente);

            Pedido salvo = pedidoRepository.save(pedido);

            return new PedidoResponse(salvo);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar pedido: " + e.getMessage());
        }
    }

    public List<PedidoResponse> buscarPedidos(){

        List<Pedido> clientes = pedidoRepository.findAll();

        return clientes.stream()
                .map(PedidoResponse::new)
                .toList();

    }

    public PedidoResponse buscarPedido(long pedidoId){

        try {
            Pedido pedido = pedidoRepository.findById(pedidoId)
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

            return new PedidoResponse(pedido);

        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public PedidoResponse atualizarPedido(long clienteId, PedidoRequest pedido, long pedidoId){

        Pedido pedidofind = pedidoRepository.getById(pedidoId);
        pedidofind.setNomeProduto(pedido.getNomeProduto());
        pedidofind.setQuantidade(pedido.getQuantidade());
        pedidofind.setPreco(pedido.getPreco());
        pedidoRepository.save(pedidofind);
        return new PedidoResponse(pedidofind);

    }


    public boolean deletarPedido(long pedidoId){

        System.out.println(pedidoId);

        pedidoRepository.deleteById(pedidoId);

        return true ;
    }




}
