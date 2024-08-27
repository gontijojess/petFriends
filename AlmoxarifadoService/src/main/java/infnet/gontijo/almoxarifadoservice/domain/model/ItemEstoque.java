package infnet.gontijo.almoxarifadoservice.domain.model;

import jakarta.persistence.*;

@Entity
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produtoId;

    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "almoxarifado_id")
    private Almoxarifado almoxarifado;

    protected ItemEstoque() {}

    public ItemEstoque(Long id, Long produtoId, int quantidade, Almoxarifado almoxarifado) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.almoxarifado = almoxarifado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }
}
