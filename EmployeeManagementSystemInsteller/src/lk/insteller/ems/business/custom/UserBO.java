package lk.insteller.ems.business.custom;

import lk.insteller.ems.business.SuperBO;

import java.util.List;

public interface UserBO extends SuperBO {

    List<String> getUserTypes() throws Exception;

    boolean isUser(String userType,String username,String email,String password) throws Exception;
}
