package mk.metalkat.webemt.sharedkernel.infra.eventlog;


import mk.metalkat.webemt.sharedkernel.domain.base.RemoteEventLog;

public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
