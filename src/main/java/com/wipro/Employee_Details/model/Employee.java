package com.wipro.Employee_Details.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name="Fin_Employee_Details")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private Integer empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Employee_Address> employee_addressSet;

}
