package lk.insteller.ems.business.custom.impl;

import lk.insteller.ems.business.custom.LoginBO;
import lk.insteller.ems.dao.DAOFactory;
import lk.insteller.ems.dao.DAOTypes;
import lk.insteller.ems.dao.custom.LoginDAO;

import java.util.List;

public class LoginBOImpl implements LoginBO {

    private LoginDAO loginDAO = DAOFactory.getInstance().getDAO(DAOTypes.LOGIN);


    @Override
    public List<String> getUserTypes() throws Exception {
        return loginDAO.getUserTypes();
    }

    @Override
    public boolean isUser(String userType,String email,String password) throws Exception {
        return loginDAO.existsIsUser(userType, email, password);
    }
}



