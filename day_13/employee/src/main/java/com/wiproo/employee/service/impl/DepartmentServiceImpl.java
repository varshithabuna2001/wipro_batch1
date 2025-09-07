package com.wiproo.employee.service.impl;

import com.wiproo.employee.entity.*;
import com.wiproo.employee.repository.*;
import com.wiproo.employee.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Department save(Department department) {
        return repo.save(department);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
