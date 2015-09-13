package hotelmanagement.conf;

import hotelmanagement.domain.*;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
public class EmployeeFactory {
    public static Employee createEmployee( String employee_ID,
                                           String firstnames,
                                           String lastname,
                                           List<EmployeeDemographics> emp_demo,
                                           List<EmployeeAddress> emp_address,
                                           List<EmployeeContact> emp_contact,
                                           List<Job> job,
                                           List<Manager> manager,
                                           Date hire_date)
    {
        Employee employee = new Employee
                .Builder(employee_ID)
                .employee_firstnames(firstnames)
                .employee_lastname(lastname)
                .employee_demographics(emp_demo)
                .employee_address(emp_address)
                .employee_contact(emp_contact)
                .hire_date(hire_date)
                .build();
        return employee;
    }
}
