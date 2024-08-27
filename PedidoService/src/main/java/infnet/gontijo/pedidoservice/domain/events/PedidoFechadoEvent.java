package infnet.gontijo.pedidoservice.domain.events;

public class PedidoFechadoEvent extends DomainEvent {
    private final Long pedidoId;

    public PedidoFechadoEvent(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }
}