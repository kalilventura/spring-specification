package br.com.github.kalilventura.specificationapi.specification;

import br.com.github.kalilventura.specificationapi.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> hasFirstName(String firstname) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstname"), firstname);
    }

    public static Specification<Employee> containsLastName(String lastname) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("lastname"), "%" + lastname + "%");
    }

    public static Specification<Employee> hasDepartment(String department) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("department"), department);
    }
}
