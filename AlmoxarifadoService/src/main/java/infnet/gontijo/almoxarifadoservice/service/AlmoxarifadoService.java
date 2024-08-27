package infnet.gontijo.almoxarifadoservice.service;

import infnet.gontijo.almoxarifadoservice.domain.model.ItemEstoque;
import infnet.gontijo.almoxarifadoservice.domain.repository.AlmoxarifadoRepository;
import infnet.gontijo.almoxarifadoservice.domain.repository.ItemEstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlmoxarifadoService {

    private final AlmoxarifadoRepository almoxarifadoRepository;
    private final ItemEstoqueRepository itemEstoqueRepository;

    public AlmoxarifadoService(AlmoxarifadoRepository almoxarifadoRepository, ItemEstoqueRepository itemEstoqueRepository) {
        this.almoxarifadoRepository = almoxarifadoRepository;
        this.itemEstoqueRepository = itemEstoqueRepository;
    }

    public void processarPedido(Long produtoId, int quantidade) {
        Optional<ItemEstoque> itemOpt = itemEstoqueRepository.findByProdutoId(produtoId);
        if (itemOpt.isPresent()) {
            ItemEstoque item = itemOpt.get();
            item.setQuantidade(item.getQuantidade() - quantidade);
            itemEstoqueRepository.save(item);
        } else {
            throw new IllegalArgumentException("Produto não encontrado no estoque.");
        }
    }
}