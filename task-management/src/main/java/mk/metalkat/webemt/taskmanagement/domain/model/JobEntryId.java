package mk.metalkat.webemt.taskmanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class JobEntryId extends DomainObjectId {
    private String id;

    protected JobEntryId() {
        super(DomainObjectId.randomId(JobEntryId.class).toString());
    }

    @JsonCreator
    public JobEntryId(String id) {
        super(id);
        this.id = id;
    }
}
