package mk.metalkat.webemt.taskmanagement.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.base.AbstractEntity;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
@RequiredArgsConstructor
@Getter
public class Task extends AbstractEntity<TaskId> {

    @Version
    private Long version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityLevel priorityLevel;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "estimated_time")
    private long estimatedTime;

    @Column(name = "is_finished", nullable = false)
    private boolean isFinished;

    public Task(String name, String description, PriorityLevel priorityLevel, LocalDate dueDate, long estimatedTime) {
        super(DomainObjectId.randomId(TaskId.class));
        setName(name);
        setDescription(description);
        setPriorityLevel(priorityLevel);
        setDueDate(dueDate);
        setEstimatedTime(estimatedTime);
        setFinished(false);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setEstimatedTime(long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
