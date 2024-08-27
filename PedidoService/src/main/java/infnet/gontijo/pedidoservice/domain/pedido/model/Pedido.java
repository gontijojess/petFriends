package infnet.gontijo.pedidoservice.domain.pedido.model;

import infnet.gontijo.pedidoservice.domain.pedido.valueobject.Endereco;
import infnet.gontijo.pedidoservice.domain.pedido.valueobject.ValorMonetario;
import infnet.gontijo.pedidoservice.infra.persistence.converter.ValorMonetarioConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column(name = "ENDEREÇO")
    @Embedded
    private Endereco entrega;

    @Column(name = "VALOR_TOTAL")
    @Convert(converter = ValorMonetarioConverter.class)
    private ValorMonetario valorTotal;


    public Pedido(){}

    public Pedido(Long id, Long clienteId, List<ItemPedido> itens, LocalDateTime dataCriacao, StatusPedido status, Endereco entrega) {
        this.id = id;
        this.clienteId = clienteId;
        this.itens = itens;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.entrega = entrega;
        this.valorTotal = valorTotal;
    }

    public enum StatusPedido {
        NOVO, FECHADO, CANCELADO, ENVIADO
    }


    public void adicionarItem(Long productId, int quantidade) {
        if(productId == null) {
            throw new IllegalArgumentException("Produto inválido");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade precisa ser positiva");
        }
        if (this.status != StatusPedido.NOVO) {
            throw new IllegalStateException("Não é possível adicionar itens em pedido em andamento.");
        }
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedidoId(this);
        itemPedido.setProdutoId(productId);
        itemPedido.setQuantidade(quantidade);
        if(this.itens == null) {
            this.itens = new ArrayList<>();
        }
        this.itens.add(itemPedido);
    }

    public void fecharPedido(){
        if(this.status != StatusPedido.NOVO) {
            throw new IllegalStateException("Não é possível fechar um pedido que não é novo");
        }
        if(this.itens.isEmpty()) {
            throw new IllegalStateException("Não é possível fechar um pedido vazio");
        }
        this.status = StatusPedido.FECHADO;
        //DomainEventPublisher.publish(new PedidoFechadoEvent(this));
    }

    public void cancelarPedido(){
        if(this.status != StatusPedido.FECHADO) {
            throw new IllegalStateException("Não é possível cancelar um pedido que não esteja fechado");
        }
        this.status = StatusPedido.CANCELADO;
    }

    public void enviarPedido(){
        if(this.status != StatusPedido.FECHADO) {
            throw new IllegalStateException("Não é possível enviar um pedido que não esteja fechado");
        }
        this.status = StatusPedido.ENVIADO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Endereco getEntrega() {
        return entrega;
    }

    public void setEntrega(Endereco entrega) {
        this.entrega = entrega;
    }

    public ValorMonetario getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(ValorMonetario valorTotal) {
        this.valorTotal = valorTotal;
    }
}
