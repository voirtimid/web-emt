package mk.metalkat.webemt.jobmanagement.application;

import mk.metalkat.webemt.jobmanagement.domain.model.Task;
import mk.metalkat.webemt.jobmanagement.domain.model.TaskId;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(TaskId taskId);
}
