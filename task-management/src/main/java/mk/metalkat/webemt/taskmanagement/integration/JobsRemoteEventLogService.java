package mk.metalkat.webemt.taskmanagement.integration;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.base.RemoteEventLog;
import mk.metalkat.webemt.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

@RequiredArgsConstructor
public class JobsRemoteEventLogService implements RemoteEventLog {

    private final List<StoredDomainEvent> events;

    @Override
    public List<StoredDomainEvent> events() {
        return events;
    }
}
