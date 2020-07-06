package mk.metalkat.webemt.jobmanagement.port.client;

import lombok.extern.slf4j.Slf4j;
import mk.metalkat.webemt.jobmanagement.application.TaskService;
import mk.metalkat.webemt.jobmanagement.domain.model.Task;
import mk.metalkat.webemt.jobmanagement.domain.model.TaskId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TaskClient implements TaskService {

    private final RestTemplate restTemplate;

    private final String serverUrl;

    TaskClient(@Value("${app.task-management.url}") String serverUrl,
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
    public List<Task> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/tasks").build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Task>>() {
                    }).getBody();
        } catch (Exception ex) {
            log.error("Error retrieving tasks", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public Task findById(TaskId taskId) {
        try {
            return restTemplate.exchange(uri().path("/api/tasks/" + taskId.getId()).build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Task>() {
                    }).getBody();
        } catch (Exception ex) {
            log.error("Error retrieving task by id", ex);
            return null;
        }
    }
}
