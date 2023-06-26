package com.example.ApiSpringBoot.service;

import com.example.ApiSpringBoot.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee, int id);
    public boolean deleteEmployee(int id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
}
