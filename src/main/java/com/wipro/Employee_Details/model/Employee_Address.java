package com.wipro.Employee_Details.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="Fin_Employee_Address")
public class Employee_Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Addr_ID")
    private Integer addrId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMP_ID")
    @JsonIgnore
    private Employee employee;
}
