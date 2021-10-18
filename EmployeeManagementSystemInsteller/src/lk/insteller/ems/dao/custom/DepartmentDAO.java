package lk.insteller.ems.dao.custom;

import lk.insteller.ems.dao.CrudDAO;
import lk.insteller.ems.entity.Department;
import lk.insteller.ems.entity.Employee;

public interface DepartmentDAO extends CrudDAO<Department,String> {
    boolean existsByDepartmentId(String nic);
}
