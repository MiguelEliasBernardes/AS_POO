package AP2_POO.demo.DTO;

import AP2_POO.demo.models.Cliente;

public class ClienteResponse {

    public String nome;
    public String telefone;

    public ClienteResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
