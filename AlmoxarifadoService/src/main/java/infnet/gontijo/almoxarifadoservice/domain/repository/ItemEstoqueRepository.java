package infnet.gontijo.almoxarifadoservice.domain.repository;

import infnet.gontijo.almoxarifadoservice.domain.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long> {
    Optional<ItemEstoque> findByProdutoId(Long produtoId);
}
