package lk.insteller.ems.dao.custom.impl;

import lk.insteller.ems.dao.CrudUtil;
import lk.insteller.ems.dao.custom.EmployeeDAO;
import lk.insteller.ems.entity.Employee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public String getLastEmployeeId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT empId FROM Employee ORDER BY empId DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean existsByDepartmentId(String depId) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee WHERE depId=?", depId);
        return rst.next();
    }

//    @Override
//    public List<Employee> getEmployee(String empId) throws Exception {
//        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee WHERE empId LIKE ? || emp_Name like ? || dep_Name like ? " +
//                "|| position like ? || salary like ? || joined_Date like ? || depId like ?",empId,empId,empId,empId,empId,
//                empId,empId);
//        List<Employee> employees = new ArrayList<>();
//        while (rst.next()) {
//            employees.add(new Employee(rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getDouble(5),
//                    rst.getDate(6),
//                    rst.getString(7)));
//        }
//        System.out.println(employees);
//        return employees;
//    }

    @Override
    public List<Employee> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee");
        List<Employee> employees = new ArrayList<>();
        while (rst.next()) {
            employees.add(new Employee(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7)));
        }
        return employees;
    }

    @Override
    public Employee find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee WHERE empId=?", s);
        if (rst.next()) {
            return new Employee(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7));
        }
        return null;
    }

    @Override
    public boolean save(Employee entity) throws Exception {
        return CrudUtil.execute("INSERT INTO Employee VALUES (?,?,?,?,?,?,?)", entity.getEmpId(), entity.getEmp_Name(), entity.getDep_Name(), entity.getPosition(), entity.getSalary(), entity.getJoined_Date(), entity.getDepId());
    }

    @Override
    public boolean update(Employee employee) throws Exception {
        return CrudUtil.execute("UPDATE Employee SET emp_Name=?, dep_Name=?, position=?, salary=?, joined_Date=?, depId=?  WHERE empId=?", employee.getEmp_Name(), employee.getDep_Name(), employee.getPosition(), employee.getSalary(), employee.getJoined_Date(), employee.getDepId(), employee.getEmpId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Employee WHERE empId=?", s);
    }
}
