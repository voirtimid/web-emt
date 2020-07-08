package mk.metalkat.webemt.taskmanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class JobId extends DomainObjectId {

    private String id;

    protected JobId() {
        super(DomainObjectId.randomId(JobId.class).toString());
    }

    @JsonCreator
    public JobId(String id) {
        super(id);
        this.id = id;
    }
}
