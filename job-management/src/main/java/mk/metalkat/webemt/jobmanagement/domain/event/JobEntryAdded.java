package mk.metalkat.webemt.jobmanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.metalkat.webemt.jobmanagement.domain.model.EmployeeId;
import mk.metalkat.webemt.jobmanagement.domain.model.JobEntryId;
import mk.metalkat.webemt.jobmanagement.domain.model.JobId;
import mk.metalkat.webemt.jobmanagement.domain.model.TaskId;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;

@Getter
public class JobEntryAdded implements DomainEvent {

    @JsonProperty("jobId")
    private final JobId jobId;

    @JsonProperty("jobEntryId")
    private final JobEntryId jobEntryId;

    @JsonProperty("taskId")
    private final TaskId taskId;

    @JsonProperty("employeeId")
    private final EmployeeId employeeId;

    @JsonProperty("createdAt")
    private final Instant createdAt;

    @JsonCreator
    public JobEntryAdded(@JsonProperty("createdAt") @NonNull Instant createdAt,
                      @JsonProperty("jobId") @NonNull JobId jobId,
                      @JsonProperty("jobEntryId") @NonNull JobEntryId jobEntryId,
                      @JsonProperty("employeeId") @NonNull EmployeeId employeeId,
                      @JsonProperty("taskId") @NonNull TaskId taskId) {
        this.createdAt = createdAt;
        this.jobId = jobId;
        this.employeeId = employeeId;
        this.jobEntryId = jobEntryId;
        this.taskId = taskId;
    }

    @Override
    public Instant createdAt() {
        return createdAt;
    }
}
