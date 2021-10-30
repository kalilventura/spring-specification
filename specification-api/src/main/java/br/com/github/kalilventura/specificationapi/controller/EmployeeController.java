package br.com.github.kalilventura.specificationapi.controller;

import br.com.github.kalilventura.specificationapi.model.Employee;
import br.com.github.kalilventura.specificationapi.repository.IEmployeeSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.github.kalilventura.specificationapi.specification.EmployeeSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

@RestController
public class EmployeeController {
    private final IEmployeeSpecificationRepository employeeRepository;

    @Autowired
    public EmployeeController(IEmployeeSpecificationRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{firstname}/{department}")
    public List<Employee> findByFirstnameAndDepartment(@PathVariable("firstname") String firstname, @PathVariable("department") String department) {
        return employeeRepository.findAll(where(hasFirstName(firstname).and(hasDepartment(department))));
    }

    @GetMapping("/employees/{lastname}")
    public List<Employee> findByFirstnameAndDepartment(@PathVariable("lastname") String lastname) {
        return employeeRepository.findAll(containsLastName(lastname));
    }


}

