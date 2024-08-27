package infnet.gontijo.almoxarifadoservice.web.controller;

import infnet.gontijo.almoxarifadoservice.service.AlmoxarifadoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/almoxarifado")
public class AlmoxarifadoController {

    private final AlmoxarifadoService almoxarifadoService;

    public AlmoxarifadoController(AlmoxarifadoService almoxarifadoService) {
        this.almoxarifadoService = almoxarifadoService;
    }

    @PostMapping("/processar-pedido")
    public void processarPedido(@RequestParam Long produtoId, @RequestParam int quantidade) {
        almoxarifadoService.processarPedido(produtoId, quantidade);
    }
}
