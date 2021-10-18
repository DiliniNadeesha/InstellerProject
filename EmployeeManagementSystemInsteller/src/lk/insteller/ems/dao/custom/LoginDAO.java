package lk.insteller.ems.dao.custom;

import lk.insteller.ems.dao.CrudDAO;
import lk.insteller.ems.entity.Login;

import java.util.List;

public interface LoginDAO extends CrudDAO<Login,Integer> {

    public boolean existsIsUser(String usertype, String email, String password) throws Exception;

    List<String> getUserTypes() throws Exception;
}
