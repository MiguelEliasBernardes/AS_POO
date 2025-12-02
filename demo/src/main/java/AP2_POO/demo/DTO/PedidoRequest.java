package AP2_POO.demo.DTO;

import AP2_POO.demo.models.Pedido;

public class PedidoRequest {

    public String nomeProduto;
    public double preco;
    public int quantidade;

    public PedidoRequest() {}

    public PedidoRequest(Pedido pedido) {
        this.nomeProduto = pedido.getNomeProduto();
        this.preco = pedido.getPreco();
        this.quantidade = pedido.getQuantidade();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
