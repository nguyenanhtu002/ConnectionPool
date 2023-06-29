package com.example.ApiSpringBoot.controller;

import com.example.ApiSpringBoot.entity.Employee;
import com.example.ApiSpringBoot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/list")
    public List<Employee> listEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("get/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }
}
