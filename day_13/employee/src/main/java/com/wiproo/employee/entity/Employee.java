package com.wiproo.employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            

    @Column(unique = true, nullable = false)
    private String empId;      
    private String empName;

    
    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department dept;

    public Employee() {}

    public Employee(String empId, String empName, Department dept) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public Department getDept() { return dept; }
    public void setDept(Department dept) { this.dept = dept; }
}
