package mk.metalkat.webemt.jobmanagement.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode(callSuper = false)
public class JobId extends DomainObjectId {

    protected JobId() {
        super("");
    }

    public JobId(@NonNull String id) {
        super(id);
    }
}
