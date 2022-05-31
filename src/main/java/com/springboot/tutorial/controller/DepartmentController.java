package com.springboot.tutorial.controller;

import com.springboot.tutorial.entity.Department;
import com.springboot.tutorial.error.DepartmentNotFoundException;
import com.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside saveDepartment of class DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        logger.info("Inside fetchDepartmentList of class DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
        logger.info("Inside fetchDepartment of class DepartmentController");
        return departmentService.fetchDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        logger.info("Inside deleteDepartmentById of class DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long id) {
        logger.info("Inside updateDepartment of class DepartmentController");
        return departmentService.updateDepartment(department, id);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByDepartmentName(@PathVariable("name") String departmentName) {
        logger.info("Inside fetchDepartmentByDepartmentName of class DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
