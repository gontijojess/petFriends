package infnet.gontijo.pedidoservice.domain.pedido.model;

import infnet.gontijo.pedidoservice.domain.pedido.valueobject.ValorMonetario;
import infnet.gontijo.pedidoservice.infra.persistence.converter.ValorMonetarioConverter;
import jakarta.persistence.*;

@Table(name = "ITEM_PEDIDO")
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    @Convert(converter = ValorMonetarioConverter.class)
    private ValorMonetario valorTotal;

    @ManyToOne
    @JoinColumn(name = "PEDIDO", referencedColumnName = "ID")
    private Pedido pedido;

    @Column(name = "PRODUTO_ID")
    private Long produtoId;

    public ItemPedido(){}

    public ItemPedido(Long id, int quantidade, ValorMonetario valorTotal, Pedido pedido, Long produtoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produtoId = produtoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ValorMonetario getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(ValorMonetario valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedidoId(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}