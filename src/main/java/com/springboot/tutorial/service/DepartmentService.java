package com.springboot.tutorial.service;

import com.springboot.tutorial.entity.Department;
import com.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartment(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Department department, Long id);

    public Department fetchDepartmentByName(String departmentName);
}
