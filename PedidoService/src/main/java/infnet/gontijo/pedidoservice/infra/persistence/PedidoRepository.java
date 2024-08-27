package infnet.gontijo.pedidoservice.infra.persistence;

import infnet.gontijo.pedidoservice.domain.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
