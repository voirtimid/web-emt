package mk.metalkat.webemt.employeemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId extends DomainObjectId {

    protected EmployeeId() {
        super(DomainObjectId.randomId(EmployeeId.class).toString());
    }

    @JsonCreator
    public EmployeeId(String id) {
        super(id);
    }
}
