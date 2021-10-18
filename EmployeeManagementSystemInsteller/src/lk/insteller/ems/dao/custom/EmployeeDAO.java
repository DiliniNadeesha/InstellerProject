package lk.insteller.ems.dao.custom;

import lk.insteller.ems.dao.CrudDAO;
import lk.insteller.ems.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee,String> {

    String getLastEmployeeId() throws Exception;

    boolean existsByDepartmentId(String depId) throws Exception;

    //List<Employee> getEmployee(String empId) throws Exception;
}
