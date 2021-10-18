package lk.insteller.ems.business.custom.impl;

import lk.insteller.ems.business.custom.UserBO;
import lk.insteller.ems.dao.DAOFactory;
import lk.insteller.ems.dao.DAOTypes;
import lk.insteller.ems.dao.custom.LoginDAO;
import lk.insteller.ems.dao.custom.UserDAO;

import java.util.List;

public class UserBOImpl implements UserBO {

    private UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER);

    @Override
    public List<String> getUserTypes() throws Exception {
        return userDAO.getUserTypes();
    }

    @Override
    public boolean isUser(String userType, String username, String email, String password) throws Exception {
        return userDAO.existsIsUser(userType, username, email, password);
    }
}
