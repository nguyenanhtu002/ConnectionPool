package com.example.ApiSpringBoot.service;

import com.example.ApiSpringBoot.model.Employee;
import com.example.ApiSpringBoot.repository.EmployeeReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements  IEmployeeService{
    @Autowired
    private EmployeeReponsitory employeeReponsitory;
    @Override
    public Employee addEmployee(Employee employee) {
        if(employee!= null){
            return employeeReponsitory.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
            if(employee != null){
                Employee employeeUpdate= employeeReponsitory.getById(id);
                if(employeeUpdate != null)
                {
                    employeeUpdate.setName(employee.getName());
                    employeeUpdate.setAddress(employee.getAddress());
                    return employeeReponsitory.save(employeeUpdate);
                }
            }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if(id>=1) {
                Employee employee =employeeReponsitory.getById(id);
                if(employee !=  null) {
                    employeeReponsitory.deleteById(id);
                    return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeReponsitory.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeReponsitory.getById(id);
    }
}
