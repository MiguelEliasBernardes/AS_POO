package AP2_POO.demo.DTO;

import AP2_POO.demo.models.Pedido;

public class PedidoResponse {

    public String nomeProduto;
    public double preco;
    public int quantidade;

    public PedidoResponse(Pedido pedido) {
        this.nomeProduto = pedido.getNomeProduto();
        this.preco = pedido.getPreco();
        this.quantidade = pedido.getQuantidade();
    }

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nome) {
        this.nomeProduto = nomeProduto;
    }

}
