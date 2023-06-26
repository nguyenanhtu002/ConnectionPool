package com.example.ApiSpringBoot.controller;

import com.example.ApiSpringBoot.model.Employee;
import com.example.ApiSpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return iEmployeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam("id") int id, @RequestBody Employee employee) {
        return iEmployeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") int id) {
        return iEmployeeService.deleteEmployee(id);
    }

    @GetMapping("/list")
    public List<Employee> listEmployee() {
        return iEmployeeService.getAllEmployees();
    }


}
