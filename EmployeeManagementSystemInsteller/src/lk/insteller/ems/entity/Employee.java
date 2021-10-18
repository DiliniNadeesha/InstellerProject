package lk.insteller.ems.entity;

import java.sql.Date;

// According To Java BeanSpec:
public class Employee implements SuperEntity {

    private String empId;
    private String emp_Name;
    private String dep_Name;
    private String position;
    private double salary;
    private String joined_Date;
    private String depId;

    public Employee(String empId, String emp_Name, String dep_Name, String position, double salary, String joined_Date, String depId) {
        this.empId = empId;
        this.emp_Name = emp_Name;
        this.dep_Name = dep_Name;
        this.position = position;
        this.salary = salary;
        this.joined_Date = joined_Date;
        this.depId = depId;
    }

    public Employee() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getDep_Name() {
        return dep_Name;
    }

    public void setDep_Name(String dep_Name) {
        this.dep_Name = dep_Name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJoined_Date() {
        return joined_Date;
    }

    public void setJoined_Date(String joined_Date) {
        this.joined_Date = joined_Date;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", emp_Name='" + emp_Name + '\'' +
                ", dep_Name='" + dep_Name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", joined_Date='" + joined_Date + '\'' +
                ", depId='" + depId + '\'' +
                '}';
    }
}
