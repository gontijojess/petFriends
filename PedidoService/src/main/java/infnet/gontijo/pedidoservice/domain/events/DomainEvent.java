package infnet.gontijo.pedidoservice.domain.events;

import java.time.LocalDateTime;

public abstract class DomainEvent {
    private final LocalDateTime occurredAt;

    protected DomainEvent() {
        this.occurredAt = LocalDateTime.now();
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}