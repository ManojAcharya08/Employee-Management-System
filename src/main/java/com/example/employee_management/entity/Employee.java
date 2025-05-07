package com.example.employee_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Default constructor for JPA
    public Employee() {}

    // Constructor for initializing an employee
    public Employee(String name, String email, Department department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getter for 'id' field
    public Long getId() {
        return id;
    }

    // Setter for 'id' field
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for 'name' field
    public String getName() {
        return name;
    }

    // Setter for 'name' field
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'email' field
    public String getEmail() {
        return email;
    }

    // Setter for 'email' field
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for 'department' field
    public Department getDepartment() {
        return department;
    }

    // Setter for 'department' field
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Optional: Override toString() for meaningful logging/debugging
    @Override
    public String toString() {
        return String.format("Employee [id=%d, name='%s', email='%s', department='%s']",
                id, name, email, (department != null ? department.getName() : "N/A"));
    }
}
