package com.vladproduction.jpabasic.repository;

import com.vladproduction.jpabasic.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 15-Apr-24
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
