package mk.metalkat.webemt.taskmanagement.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainEvent;
import mk.metalkat.webemt.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.metalkat.webemt.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobCreatedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.metalkat.webemt.taskmanagement.integration.JobCreatedEvent");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, JobCreatedEvent.class));
    }
}
