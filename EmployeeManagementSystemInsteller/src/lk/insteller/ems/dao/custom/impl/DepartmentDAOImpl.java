package lk.insteller.ems.dao.custom.impl;

import lk.insteller.ems.dao.custom.DepartmentDAO;
import lk.insteller.ems.entity.Department;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public boolean existsByDepartmentId(String nic) {
        return false;
    }

    @Override
    public List<Department> findAll() throws Exception {
        return null;
    }

    @Override
    public Department find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Department entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Department entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}
