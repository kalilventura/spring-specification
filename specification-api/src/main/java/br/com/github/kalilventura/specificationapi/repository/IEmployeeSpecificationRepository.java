package br.com.github.kalilventura.specificationapi.repository;

import br.com.github.kalilventura.specificationapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEmployeeSpecificationRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
