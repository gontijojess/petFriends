package infnet.gontijo.pedidoservice.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String DOMAIN_EVENTS_QUEUE = "domain-events-queue";

    @Bean
    public Queue domainEventsQueue() {
        return new Queue(DOMAIN_EVENTS_QUEUE, true);
    }
}
