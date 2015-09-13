package hotelmanagement.services;

import hotelmanagement.domain.Employee;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public boolean createEmployee(String idNumber, String firstName, String lastName, Date hireDate,
                                  String gender, String race, String homeLanguage, String physicalAddress,
                                  String postalAddress, String postalCode, String cellNumber, String homeNumber,
                                  String emailAddress, String NOKN, String jobCode, String jobType, String jobTitle,
                                  String jobDescription, double salary, String managerID, String managerTitle);
    public boolean updateEmployee(String idNumber, String firstName, String lastName, Date hireDate,
                                  String gender, String race, String homeLanguage, String physicalAddress,
                                  String postalAddress, String postalCode, String cellNumber, String homeNumber,
                                  String emailAddress, String NOKN, String jobCode, String jobType, String jobTitle,
                                  String jobDescription, double salary, String managerID, String managerTitle);
}
