package com.wiproo.employee.service;

import com.wiproo.employee.entity.*;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    Optional<Employee> findByEmpId(String empId);
    List<Employee> findAll();
    Employee update(Long id, Employee employee);
    void deleteById(Long id);
}
