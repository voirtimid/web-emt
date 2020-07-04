package mk.metalkat.webemt.taskmanagement.port.rest;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.taskmanagement.application.TaskService;
import mk.metalkat.webemt.taskmanagement.domain.model.Task;
import mk.metalkat.webemt.taskmanagement.domain.model.TaskId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable("id") String taskId) {
        return taskService.findById(new TaskId(taskId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
