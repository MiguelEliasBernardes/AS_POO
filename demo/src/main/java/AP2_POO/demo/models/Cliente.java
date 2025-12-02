package AP2_POO.demo.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> pedidos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
