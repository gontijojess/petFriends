package infnet.gontijo.pedidoservice.infra.persistence.converter;

import infnet.gontijo.pedidoservice.domain.pedido.valueobject.Endereco;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EnderecoConverter implements AttributeConverter<Endereco, String> {

    private static final String SEPARADOR = ",";

    @Override
    public String convertToDatabaseColumn(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        return String.join(SEPARADOR,
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getComplemento());
    }

    @Override
    public Endereco convertToEntityAttribute(String enderecoString) {
        if (enderecoString == null || enderecoString.isEmpty()) {
            return null;
        }

        String[] partes = enderecoString.split(SEPARADOR);

        if (partes.length != 7) {
            throw new IllegalArgumentException("Formato de endereço inválido. Esperado 7 partes, mas encontrado " + partes.length);
        }

        String rua = partes[0];
        String numero = partes[1];
        String bairro = partes[2];
        String cidade = partes[3];
        String estado = partes[4];
        String cep = partes[5];
        String complemento = partes[6];

        return new Endereco(rua, numero, bairro, cidade, estado, cep, complemento);
    }
}
