package lk.insteller.ems.dao.custom.impl;

import lk.insteller.ems.dao.CrudUtil;
import lk.insteller.ems.dao.custom.LoginDAO;
import lk.insteller.ems.entity.Login;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean existsIsUser(String usertype ,String email,  String password ) throws Exception {
        ResultSet rst =  CrudUtil.execute("SELECT * FROM login WHERE usertype=? AND email=? AND password=?",usertype,email,password);
        if (rst.next()){
            return true;
        }else {
            return false;
        }
    }

    public List<String> getUserTypes() throws Exception {
        ResultSet rst =CrudUtil.execute("SELECT DISTINCT usertype FROM login");
        List<String> userTypes=new ArrayList<>();
        while(rst.next()){
            userTypes.add(rst.getString(1));
        }
        return userTypes;
    }

    @Override
    public List<Login> findAll() throws Exception {
        return null;
    }

    @Override
    public Login find(Integer integer) throws Exception {
        return null;
    }

    @Override
    public boolean save(Login entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Login entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }
}
