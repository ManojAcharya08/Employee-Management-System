package com.example.employee_management.controller;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Show the form to add a new employee
    @GetMapping("/add-employee")
    public String showAddEmployeePage() {
        return "add-employee";  // Name of the Thymeleaf template for adding employees
    }

    // Handle form submission for adding a new employee
    @PostMapping("/add-employee")
    public String addEmployee(Employee employee) {
        employeeService.createEmployee(employee);  // Save the employee to DB
        return "redirect:/view-employees";  // Redirect to employee list page after saving
    }

    // Display the list of employees
    @GetMapping("/view-employees")
    public String showEmployeesPage(Model model) {
        List<Employee> employees = employeeService.getAllEmployeesList();  // Fetch employees
        model.addAttribute("employees", employees);  // Pass to template
        return "view-employees";  // Name of the Thymeleaf template to display employees
    }
}
