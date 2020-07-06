package mk.metalkat.webemt.jobmanagement.domain.model;

import lombok.*;
import mk.metalkat.webemt.sharedkernel.domain.base.AbstractEntity;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;

@Entity
@Table(name = "job_entries")
@Getter
@Setter
@NoArgsConstructor
public class JobEntry extends AbstractEntity<JobEntryId> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "task_id", nullable = false))
    private TaskId taskId;

    @Column(name = "remark")
    private String remark;

    @Column(name = "tracked_time", nullable = false)
    private Long trackedTime;

    public JobEntry(@NonNull TaskId taskId, String remark, Long trackedTime) {
        super(DomainObjectId.randomId(JobEntryId.class));
        setTaskId(taskId);
        setRemark(remark);
        if (trackedTime < 0) {
            throw new IllegalArgumentException("Tracked time cannot be negative");
        }
        setTrackedTime(trackedTime);
    }

}
