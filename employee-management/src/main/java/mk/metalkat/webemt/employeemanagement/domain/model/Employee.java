package mk.metalkat.webemt.employeemanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.base.AbstractEntity;
import mk.metalkat.webemt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
public class Employee extends AbstractEntity<EmployeeId> {

    @Version
    private Long version;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Employee(String firstName, String lastName) {
        super(DomainObjectId.randomId(EmployeeId.class));
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDeleted = false;
    }
}
