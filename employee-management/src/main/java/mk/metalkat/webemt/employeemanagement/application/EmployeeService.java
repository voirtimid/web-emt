package mk.metalkat.webemt.employeemanagement.application;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.employeemanagement.domain.model.Employee;
import mk.metalkat.webemt.employeemanagement.domain.model.EmployeeId;
import mk.metalkat.webemt.employeemanagement.domain.repository.EmployeeRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @NonNull
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @NonNull
    public Optional<Employee> findById(@NonNull EmployeeId employeeId) {
        Objects.requireNonNull(employeeId, "employeeId must not be null");
        return employeeRepository.findById(employeeId);
    }

}
