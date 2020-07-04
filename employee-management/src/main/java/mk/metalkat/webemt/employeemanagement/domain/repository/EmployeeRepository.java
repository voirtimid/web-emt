package mk.metalkat.webemt.employeemanagement.domain.repository;

import mk.metalkat.webemt.employeemanagement.domain.model.Employee;
import mk.metalkat.webemt.employeemanagement.domain.model.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {
}
