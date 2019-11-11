package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author apa
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
