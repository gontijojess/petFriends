package infnet.gontijo.pedidoservice.infra.messaging;

import infnet.gontijo.pedidoservice.domain.events.DomainEvent;
import infnet.gontijo.pedidoservice.infra.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class DomainEventPublisher {

    private static RabbitTemplate rabbitTemplate;

    @Autowired
    public DomainEventPublisher(RabbitTemplate rabbitTemplate) {
        DomainEventPublisher.rabbitTemplate = rabbitTemplate;
    }

    public static void publish(DomainEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DOMAIN_EVENTS_QUEUE, event);
    }
}