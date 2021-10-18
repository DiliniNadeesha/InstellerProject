package lk.insteller.ems.business.custom;

import lk.insteller.ems.business.SuperBO;
import lk.insteller.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeBO extends SuperBO {

    boolean saveEmployee(EmployeeDTO employee)throws Exception;

    boolean updateEmployee(EmployeeDTO employee)throws Exception;

    boolean deleteEmployee(String empId) throws Exception;

    List<EmployeeDTO> findAllEmployee() throws Exception;

    String getLastEmployeeId()throws Exception;

    EmployeeDTO findEmployee(String empId) throws Exception;

    List<String> getAllEmployeeIDs() throws Exception;

//    public boolean saveEmployee(String empId , String emp_Name, String dep_name, String position, double salary, String joined_Date, String depId) throws Exception;
//
//    public boolean updateEmployee(String emp_Name, String dep_name, String position, double salary, String joined_Date, String depId, String empId)throws Exception;

    //List<EmployeeDTO> getEmployeeInfo(String s) throws Exception;


}
