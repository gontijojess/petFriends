package infnet.gontijo.pedidoservice.infra.persistence.converter;

import infnet.gontijo.pedidoservice.domain.pedido.valueobject.ValorMonetario;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter(autoApply = true)
public class ValorMonetarioConverter implements AttributeConverter<ValorMonetario, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(ValorMonetario attribute) {
        return attribute != null ? attribute.getQuantia() : null;
    }

    @Override
    public ValorMonetario convertToEntityAttribute(BigDecimal dbData) {
        return dbData != null ? new ValorMonetario(dbData) : null;
    }
}
