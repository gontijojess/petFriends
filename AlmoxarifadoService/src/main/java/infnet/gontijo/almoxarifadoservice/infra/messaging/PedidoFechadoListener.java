package infnet.gontijo.almoxarifadoservice.infra.messaging;

import infnet.gontijo.almoxarifadoservice.service.AlmoxarifadoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoFechadoListener {

    private final AlmoxarifadoService almoxarifadoService;

    public PedidoFechadoListener(AlmoxarifadoService almoxarifadoService) {
        this.almoxarifadoService = almoxarifadoService;
    }

    @KafkaListener(topics = "pedido-fechado", groupId = "almoxarifado")
    public void onPedidoFechado(PedidoFechadoEvent event) {
        almoxarifadoService.processarPedido(event.getProdutoId(), event.getQuantidade());
    }
}