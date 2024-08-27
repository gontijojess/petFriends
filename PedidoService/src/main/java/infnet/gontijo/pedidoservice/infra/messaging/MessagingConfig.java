package infnet.gontijo.pedidoservice.infra.messaging;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessagingConfig {

    @Bean
    public Exchange almoxarifadoExchange() {
        return ExchangeBuilder.topicExchange("almoxarifado.exchange").durable(true).build();
    }

    @Bean
    public Queue produtoVendidoQueue() {
        return QueueBuilder.durable("produto.vendido.queue").build();
    }

    @Bean
    public Binding binding(Queue produtoVendidoQueue, Exchange almoxarifadoExchange) {
        return BindingBuilder.bind(produtoVendidoQueue).to(almoxarifadoExchange).with("produto.vendido").noargs();
    }
}
