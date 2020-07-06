package mk.metalkat.webemt.jobmanagement.domain.model;

import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class TaskId extends DomainObjectId {

    protected TaskId() {
        super(DomainObjectId.randomId(TaskId.class).toString());
    }

    public TaskId(String id) {
        super(id);
    }
}
