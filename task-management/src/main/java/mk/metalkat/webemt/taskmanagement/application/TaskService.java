package mk.metalkat.webemt.taskmanagement.application;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.taskmanagement.domain.model.Task;
import mk.metalkat.webemt.taskmanagement.domain.model.TaskId;
import mk.metalkat.webemt.taskmanagement.domain.repository.TaskRepository;
import mk.metalkat.webemt.taskmanagement.integration.JobEntryAddedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @NonNull
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @NonNull
    public Optional<Task> findById(@NonNull TaskId taskId) {
        Objects.requireNonNull(taskId, "taskId must not be null");
        return taskRepository.findById(taskId);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onJobCreatedEvent(JobEntryAddedEvent event) {
        Task task = taskRepository.findById(event.getTaskId()).orElseThrow(RuntimeException::new);
        task.addTimeToTrackedMinutes(event.getTrackedTime());
        taskRepository.save(task);
    }
}
