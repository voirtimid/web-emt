package mk.metalkat.webemt.sharedkernel.domain.base;

import mk.metalkat.webemt.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
