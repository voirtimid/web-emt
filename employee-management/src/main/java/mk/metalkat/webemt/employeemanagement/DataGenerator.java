package mk.metalkat.webemt.employeemanagement;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.employeemanagement.domain.model.Employee;
import mk.metalkat.webemt.employeemanagement.domain.model.EmployeeId;
import mk.metalkat.webemt.employeemanagement.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataGenerator {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    @Transactional
    public void generateData() {
        if (employeeRepository.findAll().size() == 0) {
            List<Employee> employees = new ArrayList<>();
            employees.add(createEmployee("Oliver", "Dimitriov"));
            employees.add(createEmployee("Anton", "Kahwaji"));
            employees.add(createEmployee("Nikola", "Hristovski"));
            employeeRepository.saveAll(employees);
        }
    }

    private Employee createEmployee(String firstName, String lastName) {
        return new Employee(firstName, lastName);
    }

}
