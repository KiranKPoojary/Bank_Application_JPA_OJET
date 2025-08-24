package com.example.bank_application.repository;

import com.example.bank_application.entity.Employee;
import com.example.bank_application.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
