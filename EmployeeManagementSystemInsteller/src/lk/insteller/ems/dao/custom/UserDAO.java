package lk.insteller.ems.dao.custom;

import lk.insteller.ems.dao.CrudDAO;
import lk.insteller.ems.entity.Login;
import lk.insteller.ems.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User,Integer> {

    public boolean existsIsUser(String usertype, String username, String email, String password) throws Exception;

    List<String> getUserTypes() throws Exception;
}
