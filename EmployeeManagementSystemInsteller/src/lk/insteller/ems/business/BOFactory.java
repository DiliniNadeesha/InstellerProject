package lk.insteller.ems.business;

import lk.insteller.ems.business.custom.impl.DepartmentBOImpl;
import lk.insteller.ems.business.custom.impl.EmployeeBOImpl;
import lk.insteller.ems.business.custom.impl.LoginBOImpl;
import lk.insteller.ems.business.custom.impl.UserBOImpl;
import lk.insteller.ems.entity.Employee;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null)? (boFactory = new BOFactory()): boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case LOGIN:
                return (T) new LoginBOImpl();
            case USER:
                return (T) new UserBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();
            case DEPARTMENT:
                return (T) new DepartmentBOImpl();
            default:
                return null;
        }
    }
}
