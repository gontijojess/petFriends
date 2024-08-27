package infnet.gontijo.pedidoservice.domain.pedido.valueobject;
import lombok.Value;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Value
public class ValorMonetario {

    private final BigDecimal quantia;

    public ValorMonetario(BigDecimal quantia) {
        if (quantia == null || quantia.signum() < 0) {
            throw new IllegalArgumentException("Valor Monetário não pode ser negativo");
        }
        this.quantia = quantia.setScale(2, RoundingMode.HALF_UP);
    }

    public ValorMonetario somar(ValorMonetario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Outro valor não pode ser nulo");
        }
        return new ValorMonetario(this.quantia.add(outro.getQuantia()));
    }

    public ValorMonetario subtrair(ValorMonetario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Outro valor não pode ser nulo");
        }
        return new ValorMonetario(this.quantia.subtract(outro.getQuantia()));
    }

}