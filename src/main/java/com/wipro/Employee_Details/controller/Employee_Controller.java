package com.wipro.Employee_Details.controller;

import com.wipro.Employee_Details.model.Employee;
import com.wipro.Employee_Details.model.Employee_Address;
import com.wipro.Employee_Details.repository.Employee_Address_Repository;
import com.wipro.Employee_Details.repository.Employee_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest")
public class Employee_Controller {

    @Autowired
    Employee_Repository employee_repository;

    @Autowired
    Employee_Address_Repository employee_address_repository;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employee_repository.findAll();
    }

    @GetMapping("/getAnEmployee/{id}")
    public Employee getAnEmployee(@PathVariable Integer id){
        return employee_repository.findById(id).get();
    }

    @DeleteMapping("/deleteAnEmployee/{id}")
    public void deleteAnEmployee(@PathVariable Integer id){
        employee_repository.deleteById(id);
    }

    @PostMapping("/createAnEmployee")
    public Employee createAnEmployee(@RequestBody Employee employee){
        Set<Employee_Address> employee_addresses=employee.getEmployee_addressSet();
        employee.setEmployee_addressSet(null);
        Employee employee1=employee_repository.save(employee);
        employee.setEmployee_addressSet(employee_addresses);
        employee_addresses.forEach(employee_address -> employee_address.setEmployee(employee1));
        return employee_repository.save(employee1);
    }

    @PutMapping("/updateAnEmployee/{id}")
    public Employee updateAnEmployee(@RequestBody Employee employee,@PathVariable Integer id){
        return employee_repository.save(employee);
    }

    @PutMapping("/updateAnEmployeeAddress/{id}")
    public Employee updateAnEmployeeAddress(@RequestBody Set<Employee_Address> employee_address,@PathVariable Integer id){
        Employee employee=employee_repository.findById(id).get();
        employee.setEmployee_addressSet(employee_address);
        return employee_repository.save(employee);
    }

    @DeleteMapping("/deleteAnEmployeeAddress/{id}")
    public Employee deleteAnEmployeeAddress(@PathVariable Integer id){
        Employee employee=employee_repository.findById(id).get();
        employee.setEmployee_addressSet(null);
        Employee employee1=employee_repository.save(employee);
        return employee1;
    }
}
