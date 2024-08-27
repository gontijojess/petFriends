package infnet.gontijo.almoxarifadoservice.infra.messaging;

public class PedidoFechadoEvent {

    private Long produtoId;
    private int quantidade;

    public PedidoFechadoEvent() {
    }

    public PedidoFechadoEvent(Long produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
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
}

