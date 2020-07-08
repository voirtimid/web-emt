package mk.metalkat.webemt.taskmanagement.integration;

import mk.metalkat.webemt.sharedkernel.domain.base.RemoteEventLog;
import mk.metalkat.webemt.sharedkernel.infra.eventlog.RemoteEventLogService;
import mk.metalkat.webemt.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class JobsEventLogService implements RemoteEventLogService {

    private final RestTemplate restTemplate;

    private final String serverUrl;

    JobsEventLogService(@Value("${app.job-management.url}") String serverUrl,
               @Value("${app.task-management.connect-timeout-ms}") int connectTimeout,
               @Value("${app.task-management.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);

        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }

    @Override
    public String source() {
        return "jobs";
    }

    @Override
    public RemoteEventLog currentLog(long lastProcessedId) {
        List<StoredDomainEvent> response = restTemplate.exchange(uri().path("/api/event-log/" + lastProcessedId)
                        .toUriString(),
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<StoredDomainEvent>>() {
                }).getBody();

        return new JobsRemoteEventLogService(response);
    }
}
