package mk.metalkat.webemt.employeemanagement.port.rest;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.employeemanagement.application.EmployeeService;
import mk.metalkat.webemt.employeemanagement.domain.model.Employee;
import mk.metalkat.webemt.employeemanagement.domain.model.EmployeeId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") String employeeId) {
        return employeeService.findById(new EmployeeId(employeeId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
