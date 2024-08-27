package infnet.gontijo.almoxarifadoservice.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Almoxarifado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almoxarifado")
    private List<ItemEstoque> itensEstoque;


    protected Almoxarifado() {}

    public Almoxarifado(Long id, List<ItemEstoque> itensEstoque) {
        this.id = id;
        this.itensEstoque = itensEstoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemEstoque> getItensEstoque() {
        return itensEstoque;
    }

    public void setItensEstoque(List<ItemEstoque> itensEstoque) {
        this.itensEstoque = itensEstoque;
    }
}
