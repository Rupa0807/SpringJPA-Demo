package com.rupa.RestJpa.Dao;

import com.rupa.RestJpa.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
