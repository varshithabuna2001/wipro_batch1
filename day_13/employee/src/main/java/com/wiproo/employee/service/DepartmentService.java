package com.wiproo.employee.service;

import com.wiproo.employee.entity.*;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department save(Department department);
    Optional<Department> findById(Long id);
    List<Department> findAll();
    void deleteById(Long id);
}
