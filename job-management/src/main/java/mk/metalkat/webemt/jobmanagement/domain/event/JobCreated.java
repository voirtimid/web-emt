package mk.metalkat.webemt.jobmanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import mk.metalkat.webemt.jobmanagement.domain.model.EmployeeId;
import mk.metalkat.webemt.jobmanagement.domain.model.JobId;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class JobCreated implements DomainEvent {

    @JsonProperty("jobId")
    private final JobId jobId;

    @JsonProperty("employeeId")
    private final EmployeeId employeeId;

    @JsonProperty("createdAt")
    private final Instant createdAt;

    @JsonCreator
    public JobCreated(@JsonProperty("createdAt") @NonNull Instant createdAt,
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
