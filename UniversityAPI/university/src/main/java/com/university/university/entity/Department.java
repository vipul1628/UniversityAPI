package com.university.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "department")
public class Department {
    @Id @Column(name = "dept_id") private Integer deptId;
    @Column(name = "dept_name", nullable = false, length = 50) private String deptName;
    @Column(length = 50) private String building;
    @Column(precision = 12, scale = 2) private BigDecimal budget;
    public Department() {}
    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }
    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }
}
