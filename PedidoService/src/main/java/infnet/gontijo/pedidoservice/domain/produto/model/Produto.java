package infnet.gontijo.pedidoservice.domain.produto.model;
import infnet.gontijo.pedidoservice.domain.produto.valueobject.ValorMonetario;
import infnet.gontijo.pedidoservice.infra.persistence.converter.ValorMonetarioConverter;
import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Convert(converter = ValorMonetarioConverter.class)
    private ValorMonetario preco;
    private int qtdEstoque;

    public Produto(){}

    public Produto(Long id, String nome, ValorMonetario preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ValorMonetario getPreco() {
        return preco;
    }

    public void setPreco(ValorMonetario preco) {
        this.preco = preco;
    }

    public void diminuirEstoque(int quantidade) {
        if (this.qtdEstoque >= quantidade) {
            this.qtdEstoque -= quantidade;
        } else {
            throw new IllegalStateException("Estoque insuficiente para o produto: " + this.nome);
        }
    }

    public void aumentarEstoque(int quantidade) {
            this.qtdEstoque += quantidade;
    }
}
