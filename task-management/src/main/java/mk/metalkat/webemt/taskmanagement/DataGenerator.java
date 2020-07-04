package mk.metalkat.webemt.taskmanagement;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.taskmanagement.domain.model.PriorityLevel;
import mk.metalkat.webemt.taskmanagement.domain.model.Task;
import mk.metalkat.webemt.taskmanagement.domain.repository.TaskRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataGenerator {

    private final TaskRepository taskRepository;

    @PostConstruct
    @Transactional
    public void generateData() {
        if (taskRepository.findAll().size() == 0) {
            List<Task> tasks = new ArrayList<>();
            tasks.add(createTask("task 1", "task 1 description", PriorityLevel.NORMAL, LocalDate.now().plusDays(2), Duration.ofHours(8).toHours()));
            tasks.add(createTask("task 2", "task 2 description", PriorityLevel.LOW, LocalDate.now().plusDays(2), Duration.ofHours(8).toHours()));
            tasks.add(createTask("task 3", "task 3 description", PriorityLevel.HIGH, LocalDate.now().plusDays(5), Duration.ofHours(18).toHours()));
            taskRepository.saveAll(tasks);
        }
    }

    private Task createTask(String name, String description, PriorityLevel priorityLevel, LocalDate dueDate, long estimatedTime) {
        return new Task(name, description, priorityLevel, dueDate, estimatedTime);
    }
}
