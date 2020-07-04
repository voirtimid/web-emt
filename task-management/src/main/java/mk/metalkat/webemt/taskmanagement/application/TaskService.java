package mk.metalkat.webemt.taskmanagement.application;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.taskmanagement.domain.model.Task;
import mk.metalkat.webemt.taskmanagement.domain.model.TaskId;
import mk.metalkat.webemt.taskmanagement.domain.repository.TaskRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

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
}
