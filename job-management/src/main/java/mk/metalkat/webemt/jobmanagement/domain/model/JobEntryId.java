package mk.metalkat.webemt.jobmanagement.domain.model;

import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class JobEntryId extends DomainObjectId {

    private String id;

    protected JobEntryId() {
        super("");
    }

    public JobEntryId(String uuid) {
        super(uuid);
        this.id = uuid;
    }
}
