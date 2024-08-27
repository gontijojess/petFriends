package infnet.gontijo.almoxarifadoservice.domain.events;

import java.io.Serializable;

public class PedidoFechadoEvent implements Serializable {

    private final Long pedidoId;

    public PedidoFechadoEvent(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }
}