package com.example.ApiSpringBoot.repository;

import com.example.ApiSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReponsitory extends JpaRepository<Employee, Integer> {


}
