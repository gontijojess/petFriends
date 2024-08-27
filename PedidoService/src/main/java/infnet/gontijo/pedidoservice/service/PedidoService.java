package infnet.gontijo.pedidoservice.service;

import infnet.gontijo.pedidoservice.domain.events.PedidoFechadoEvent;
import infnet.gontijo.pedidoservice.domain.pedido.model.Pedido;
import infnet.gontijo.pedidoservice.infra.messaging.DomainEventPublisher;
import infnet.gontijo.pedidoservice.infra.persistence.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DomainEventPublisher pedidoFechadoProducer;

    public Pedido confirmarPedido(Long pedidoId) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(pedidoId);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.fecharPedido();

            pedidoRepository.save(pedido);
            PedidoFechadoEvent evento = new PedidoFechadoEvent(pedidoId);
            DomainEventPublisher.publish(evento);

            return pedido;
        } else {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }

    public Pedido buscarPedidoPorId(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));
    }

    public Pedido criarPedido(Pedido pedido) {
        Long clienteId = pedido.getClienteId();

        pedido.setStatus(Pedido.StatusPedido.NOVO);
        pedido.setDataCriacao(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }
}
