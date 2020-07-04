package mk.metalkat.webemt.taskmanagement.domain.repository;

import mk.metalkat.webemt.taskmanagement.domain.model.Task;
import mk.metalkat.webemt.taskmanagement.domain.model.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, TaskId> {
}
