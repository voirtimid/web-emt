package mk.metalkat.webemt.taskmanagement.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainEvent;
import mk.metalkat.webemt.taskmanagement.domain.model.EmployeeId;
import mk.metalkat.webemt.taskmanagement.domain.model.JobId;
import org.springframework.lang.NonNull;

import java.time.Instant;

@Getter
public class JobCreatedEvent implements DomainEvent {

    @JsonProperty("jobId")
    private final JobId jobId;

    @JsonProperty("employeeId")
    private final EmployeeId employeeId;

    @JsonProperty("createdAt")
    private final Instant createdAt;

    @JsonCreator
    public JobCreatedEvent(@JsonProperty("createdAt") @NonNull Instant createdAt,
                      @JsonProperty("jobId") @NonNull JobId jobId,
                      @JsonProperty("employeeId") @NonNull EmployeeId employeeId) {
        this.createdAt = createdAt;
        this.jobId = jobId;
        this.employeeId = employeeId;
    }

    @Override
    public Instant createdAt() {
        return createdAt;
    }
}
