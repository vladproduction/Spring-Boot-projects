package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by vladproduction on 15-Apr-24
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findDepartmentByDepartmentLocation(String departmentLocation);

    Optional<Department> findByDepartmentPhone(String departmentPhone);

    Optional<Department> findByDepartmentName(String departmentName);
}
