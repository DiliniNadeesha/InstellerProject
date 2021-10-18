package lk.insteller.ems.business.custom.impl;

import lk.insteller.ems.business.custom.EmployeeBO;
import lk.insteller.ems.business.exception.AlreadyExistsInDepartmentException;
import lk.insteller.ems.dao.DAOFactory;
import lk.insteller.ems.dao.DAOTypes;
import lk.insteller.ems.dao.custom.DepartmentDAO;
import lk.insteller.ems.dao.custom.EmployeeDAO;
import lk.insteller.ems.dto.EmployeeDTO;
import lk.insteller.ems.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    /*
    ================================
    Interface through injection
    ================================
    @Override
    public void injection() {
        this.employeeDAO = DAOFactory.getInstance().getDAO(DAOType.EMPLOYEE);
    }

     ==========================
     Setter method injection
     ==========================
     private void setOrderDAO(){
        this.employeeDAO = DAOFactory.getInstance().getDAO(DAOType.EMPLOYEE);
    }

    ========================
    Dependency Declaration
    ========================
    private EmployeeDAO employeeDAO;

    public ItemBOImpl(){
        Constructor Injection
        this.employeeDAO = DAOFactory.getInstance().getDAO(DAOType.EMPLOYEE);
    }*/


    // Field Injections
    private EmployeeDAO employeeDAO = DAOFactory.getInstance().getDAO(DAOTypes.EMPLOYEE);
    private DepartmentDAO departmentDAO = DAOFactory.getInstance().getDAO(DAOTypes.DEPARTMENT);


    @Override
    public boolean saveEmployee(EmployeeDTO employee) throws Exception {
        return employeeDAO.save(new Employee(employee.getEmpId(), employee.getEmp_Name(), employee.getDep_Name(),
                employee.getPosition(), employee.getSalary(), employee.getJoined_Date(), employee.getDepId()));
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) throws Exception {
        return employeeDAO.update(new Employee(employee.getEmpId(), employee.getEmp_Name(), employee.getDep_Name(),
                employee.getPosition(), employee.getSalary(), employee.getJoined_Date(), employee.getDepId()));
    }

    @Override
    public boolean deleteEmployee(String empId) throws Exception {
        if (departmentDAO.existsByDepartmentId(empId)){
            throw new AlreadyExistsInDepartmentException("Employee already exists in an Department, hence unable to delete");
       }
       return employeeDAO.delete(empId);
    }

    @Override
    public List<EmployeeDTO> findAllEmployee() throws Exception {
        List<Employee> alEmployees = employeeDAO.findAll();
        List<EmployeeDTO> dtos = new ArrayList<>();
        for (Employee employee : alEmployees) {
            dtos.add(new EmployeeDTO(employee.getEmpId(), employee.getEmp_Name(), employee.getDep_Name(),
                    employee.getPosition(), employee.getSalary(), employee.getJoined_Date(), employee.getDepId()));
        }
        return dtos;
    }

    @Override
    public String getLastEmployeeId() throws Exception {
        return employeeDAO.getLastEmployeeId();
    }

    @Override
    public EmployeeDTO findEmployee(String empId) throws Exception {
        Employee employee = employeeDAO.find(empId);
        return new EmployeeDTO(employee.getEmpId(), employee.getEmp_Name(), employee.getDep_Name(), employee.getPosition(),
               employee.getSalary(), employee.getJoined_Date(), employee.getDepId());
    }

    @Override
    public List<String> getAllEmployeeIDs() throws Exception {
        List<Employee> employees = employeeDAO.findAll();
        List<String> ids = new ArrayList<>();
        for (Employee employee : employees) {
           ids.add(employee.getEmpId());
        }
       return ids;
    }

//    @Override
//    public boolean saveEmployee(String empId, String emp_Name, String dep_name, String position, double salary, String joined_Date, String depId) throws Exception {
//        return employeeDAO.save(new Employee(empId, emp_Name, dep_name, position, salary, joined_Date, depId));
//    }
//
//    @Override
//    public boolean updateEmployee(String emp_Name, String dep_name, String position, double salary, String joined_Date, String depId, String empId) throws Exception {
//        return employeeDAO.update(new Employee(empId, emp_Name, dep_name, position, salary, joined_Date, depId));
//    }

//    @Override
//    public List<EmployeeDTO> getEmployeeInfo(String s) throws Exception {
//        List<Employee> getEmployees = employeeDAO.getEmployee(s);
//        List<EmployeeDTO> employeeDTO = new ArrayList<>();
//        System.out.println(getEmployees);
//        for (Employee employee : getEmployees) {
//            employeeDTO.add(new EmployeeDTO(employee.getEmpId(), employee.getEmp_Name(), employee.getDep_Name(),
//                    employee.getPosition(), employee.getSalary(), employee.getJoined_Date(), employee.getDepId()));
//        }
//        return employeeDTO;
//    }
}
