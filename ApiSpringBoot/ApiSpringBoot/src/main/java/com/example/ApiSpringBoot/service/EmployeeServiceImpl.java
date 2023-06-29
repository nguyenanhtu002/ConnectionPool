package com.example.ApiSpringBoot.service;

import com.example.ApiSpringBoot.entity.Employee;
import com.example.ApiSpringBoot.exception.NotFoundException;
import com.example.ApiSpringBoot.repository.EmployeeReponsitory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeReponsitory employeeReponsitory;

    public EmployeeServiceImpl(EmployeeReponsitory employeeReponsitory) {
        this.employeeReponsitory = employeeReponsitory;
    }

@Override
public Employee addEmployee(Employee employee) {
    if (employee == null || employee.getName() == null || employee.getName().isEmpty()) {
        throw new IllegalArgumentException("Employee name cannot be null or empty");
    }
    return employeeReponsitory.save(employee);
}
    @Override
    public Employee updateEmployee(Employee employee, int id) {
        if (employee != null) {
            try {
                Employee employeeUpdate = employeeReponsitory.getById(id);
                employeeUpdate.setName(employee.getName());
                employeeUpdate.setAddress(employee.getAddress());
                return employeeReponsitory.save(employeeUpdate);
            } catch (Exception e) {
                throw new NotFoundException("Employee not found with id: " + id);
            }
        }
        return null;
    }


    @Override
    public boolean deleteEmployee(int id) {
        Optional<Employee> employeeOptional = employeeReponsitory.findById(id);
        if (employeeOptional.isPresent()) {
            employeeReponsitory.deleteById(id);
            return true;
        } else {
            throw new NotFoundException("Employee not found with id: " + id);
        }
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeReponsitory.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeReponsitory.findById(id).orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
    }
}