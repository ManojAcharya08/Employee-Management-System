package com.example.employee_management.controller;

import com.example.employee_management.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final EmployeeService employeeService;

    public PageController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Home page
    @GetMapping("/")
    public String homePage() {
        return "index";  // Displays the home page
    }

    // Add employee page
    @GetMapping("/add-employee")
    public String showAddEmployeePage() {
        return "add-employee";  // Form to add a new employee
    }

    // View employees page
    @GetMapping("/view-employees")
    public String showEmployeesPage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployeesList());  // Fetch and pass employees to view
        return "view-employees";  // Corrected template name to match the others
    }
}
