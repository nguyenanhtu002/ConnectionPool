package com.example.ApiSpringBoot.service;

import com.example.ApiSpringBoot.entity.Employee;

import java.util.List;

public interface EmployeeService {
     Employee addEmployee(Employee employee);
     Employee updateEmployee(Employee employee, int id);
     boolean deleteEmployee(int id);
     List<Employee> getAllEmployees();
     Employee getEmployee(int id);
}
