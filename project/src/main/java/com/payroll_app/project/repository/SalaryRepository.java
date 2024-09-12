package com.payroll_app.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll_app.project.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
