package com.example.employee_management.repository;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByDepartmentId(Long departmentId);
}