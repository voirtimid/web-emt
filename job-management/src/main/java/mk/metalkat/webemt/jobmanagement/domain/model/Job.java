package mk.metalkat.webemt.jobmanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.metalkat.webemt.sharedkernel.domain.base.AbstractEntity;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jobs")
@Getter
@NoArgsConstructor
public class Job extends AbstractEntity<JobId> {

    @Version
    private Long version;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<JobEntry> jobEntries;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "employee_id", nullable = false))
    private EmployeeId employeeId;

    public Job(@NonNull EmployeeId employeeId, @NonNull Instant createdAt) {
        super(DomainObjectId.randomId(JobId.class));
        setEmployeeId(employeeId);
        setCreatedAt(createdAt);
        this.jobEntries = new HashSet<>();
    }

    public JobEntry addJobEntry(@NonNull Task task) {
        Objects.requireNonNull(task, "task must not be null");

        JobEntry jobEntry = new JobEntry(task.getTaskId(), task.getRemark(), task.getTrackedTime());
        jobEntries.add(jobEntry);

        return jobEntry;
    }

    public Job(@NonNull Instant createdAt) {
        super(DomainObjectId.randomId(JobId.class));
        setCreatedAt(createdAt);
    }

    public void setJobEntries(Set<JobEntry> jobEntries) {
        this.jobEntries = jobEntries;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setEmployeeId(EmployeeId employeeId) {
        this.employeeId = employeeId;
    }

}
