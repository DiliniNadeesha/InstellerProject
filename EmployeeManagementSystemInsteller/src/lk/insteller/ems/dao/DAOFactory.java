package lk.insteller.ems.dao;

import lk.insteller.ems.business.custom.impl.DepartmentBOImpl;
import lk.insteller.ems.dao.custom.impl.DepartmentDAOImpl;
import lk.insteller.ems.dao.custom.impl.EmployeeDAOImpl;
import lk.insteller.ems.dao.custom.impl.LoginDAOImpl;
import lk.insteller.ems.dao.custom.impl.UserDAOImpl;
import lk.insteller.ems.entity.Employee;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DAOFactory()) : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case LOGIN:
                return (T) new LoginDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case DEPARTMENT:
                return (T) new DepartmentDAOImpl();
            default:
                return null;
        }
    }
}
