package com.wiproo.employee.service.impl;

import com.wiproo.employee.entity.*;
import com.wiproo.employee.repository.*;
import com.wiproo.employee.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Employee> findByEmpId(String empId) {
        return repo.findByEmpId(empId);
    }

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return repo.findById(id).map(existing -> {
            existing.setEmpId(employee.getEmpId());
            existing.setEmpName(employee.getEmpName());
            existing.setDept(employee.getDept());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
