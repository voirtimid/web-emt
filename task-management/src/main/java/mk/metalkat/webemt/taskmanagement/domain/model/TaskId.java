package mk.metalkat.webemt.taskmanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class TaskId extends DomainObjectId {
    protected TaskId() {
        super(DomainObjectId.randomId(TaskId.class).toString());
    }

    @JsonCreator
    public TaskId(String id) {
        super(id);
    }
}
