package com.wipro.Employee_Details.repository;

import com.wipro.Employee_Details.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_Repository extends JpaRepository<Employee,Integer> {
}
