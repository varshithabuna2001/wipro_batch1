package com.wipro.college;

public class Department {
    private String deptCode = "GEN";       
    private String departmentName = "General";  
    public Department() {}

    public String getDeptCode() {
        return deptCode;
    }
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptCode='" + deptCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
