package lk.insteller.ems.dao.custom.impl;

import lk.insteller.ems.dao.CrudUtil;
import lk.insteller.ems.dao.custom.UserDAO;
import lk.insteller.ems.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean existsIsUser(String usertype, String username, String email, String password) throws Exception {
        ResultSet rst =  CrudUtil.execute("SELECT * FROM user WHERE usertype=? AND username=? AND email=? AND password=?",usertype,username,email,password);
        if (rst.next()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<String> getUserTypes() throws Exception {
        ResultSet rst =CrudUtil.execute("SELECT DISTINCT usertype FROM user");
        List<String> userTypes=new ArrayList<>();
        while(rst.next()){
            userTypes.add(rst.getString(1));
        }
        return userTypes;
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }

    @Override
    public User find(Integer integer) throws Exception {
        return null;
    }

    @Override
    public boolean save(User entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(User entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }
}
