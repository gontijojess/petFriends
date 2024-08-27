package infnet.gontijo.pedidoservice.domain.pedido.valueobject;
import lombok.Value;

@Value
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep, String complemento) {
        validarCampos(rua, numero, bairro, cidade, estado, cep);
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento != null ? complemento : "";
    }

    private void validarCampos(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        if (rua == null || rua.isEmpty()) {
            throw new IllegalArgumentException("Rua não pode ser vazia.");
        }
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Número não pode ser vazio.");
        }
        if (bairro == null || bairro.isEmpty()) {
            throw new IllegalArgumentException("Bairro não pode ser vazio.");
        }
        if (cidade == null || cidade.isEmpty()) {
            throw new IllegalArgumentException("Cidade não pode ser vazia.");
        }
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("Estado não pode ser vazio.");
        }
        if (cep == null || !cep.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }

}