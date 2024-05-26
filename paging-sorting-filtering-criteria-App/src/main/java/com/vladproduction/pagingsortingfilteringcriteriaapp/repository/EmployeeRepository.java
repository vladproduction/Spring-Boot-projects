package com.vladproduction.pagingsortingfilteringcriteriaapp.repository;

import com.vladproduction.pagingsortingfilteringcriteriaapp.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
