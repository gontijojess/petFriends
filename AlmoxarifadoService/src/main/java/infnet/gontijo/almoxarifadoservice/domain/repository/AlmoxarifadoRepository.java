package infnet.gontijo.almoxarifadoservice.domain.repository;

import infnet.gontijo.almoxarifadoservice.domain.model.Almoxarifado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {
}
