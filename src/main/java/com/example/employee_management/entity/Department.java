package com.example.employee_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name is required")
    @Column(nullable = false, unique = true)
    private String name;

    // Default constructor for JPA
    public Department() {}

    // Constructor with name only
    public Department(String name) {
        this.name = name;
    }

    // Getter for 'name' field
    public String getName() {
        return name;
    }

    // Setter for 'name' field
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'id' field
    public Long getId() {
        return id;
    }

    // Setter for 'id' field
    public void setId(Long id) {
        this.id = id;
    }

    // Optional: Override toString() for meaningful logging/debugging
    @Override
    public String toString() {
        return String.format("Department [id=%d, name='%s']", id, name);
    }
}
