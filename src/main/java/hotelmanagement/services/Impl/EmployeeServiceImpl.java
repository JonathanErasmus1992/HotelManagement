package hotelmanagement.services.Impl;

import hotelmanagement.domain.*;
import hotelmanagement.repository.*;
import hotelmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo repositoryEmployee;

    @Autowired
    private EmployeeDemographicsRepo repositoryDemographics;

    @Autowired
    private EmployeeAddressRepo repositoryEAddress;

    @Autowired
    private EmployeeContactRepo repositoryEContact;

    @Autowired
    private JobRepo repositoryJob;

    @Autowired
    private ManagerRepo repositoryManager;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<Employee>();

        Iterable<Employee> employees = repositoryEmployee.findAll();
        for (Employee employee : employees) {
            allEmployees.add(employee);
        }
        return allEmployees;
    }

    @Override
    public boolean createEmployee(String idNumber, String firstName, String lastName, Date hireDate, String gender, String race, String homeLanguage, String physicalAddress, String postalAddress, String postalCode, String cellNumber, String homeNumber, String emailAddress, String NOKN, String jobCode, String jobType, String jobTitle, String jobDescription, double salary, String managerID, String managerTitle) {
        int count = 0;
        boolean blnCreateEmployee;

        List<EmployeeDemographics> employeeDemographicsList = new ArrayList<EmployeeDemographics>();
        List<EmployeeContact> employeeContactList = new ArrayList<EmployeeContact>();
        List<EmployeeAddress> employeeAddressList = new ArrayList<EmployeeAddress>();
        List<Job> jobList = new ArrayList<Job>();
        List<Manager> managerList = new ArrayList<Manager>();

        Iterable<Employee> employees = repositoryEmployee.findAll();
        for (Employee employee : employees) {
            if (employee.getIDNumber().equalsIgnoreCase(idNumber))
            {
                count = count + 1;
                employeeDemographicsList = employee.getEmployeeDemographics();
                employeeContactList = employee.getEmployeeContact();
                employeeAddressList = employee.getEmployeeAddress();
                jobList = employee.getJob();
                managerList = employee.getManager();
            }
        }

        System.out.println(" " + count);
        System.out.println(" " + idNumber + " " + firstName + " " + lastName);

        if (count == 0)
        {
            EmployeeDemographics employeeDemographics = new EmployeeDemographics.Builder(race)
                    .gender(gender)
                    .home_language(homeLanguage)
                    .build();
            repositoryDemographics.save(employeeDemographics);
            employeeDemographicsList.add(employeeDemographics);

            EmployeeContact employeeContact = new EmployeeContact.Builder(cellNumber)
                    .home_number(homeNumber)
                    .email_address(emailAddress)
                    .next_of_kin_contact(NOKN)
                    .build();
            repositoryEContact.save(employeeContact);
            employeeContactList.add(employeeContact);

            EmployeeAddress employeeAddress = new EmployeeAddress.Builder(physicalAddress)
                    .postal_address(postalAddress)
                    .postal_code(postalCode)
                    .build();
            repositoryEAddress.save(employeeAddress);
            employeeAddressList.add(employeeAddress);

            Job job = new Job.Builder(jobCode)
                    .job_title(jobTitle)
                    .job_description(jobDescription)
                    .job_type(jobType)
                    .basic_salary(salary)
                    .build();
            repositoryJob.save(job);
            jobList.add(job);

            Manager manager = new Manager.Builder(managerID)
                    .manager_title(managerTitle)
                    .build();
            repositoryManager.save(manager);
            managerList.add(manager);

            Date dateTemp = new Date();

            Employee employee = new Employee.Builder(idNumber)
                    .employee_firstnames(firstName)
                    .employee_lastname(lastName)
                    .employee_demographics(employeeDemographicsList)
                    .employee_address(employeeAddressList)
                    .employee_contact(employeeContactList)
                    .job(jobList)
                    .manager(managerList)
                    .hire_date(dateTemp)
                    .build();
            repositoryEmployee.save(employee);
            blnCreateEmployee = true;
        }
        else
        {
            blnCreateEmployee = false;
        }

        return blnCreateEmployee;
    }

    @Override
    public boolean updateEmployee(String idNumber, String firstName, String lastName, Date hireDate, String gender, String race, String homeLanguage, String physicalAddress, String postalAddress, String postalCode, String cellNumber, String homeNumber, String emailAddress, String NOKN, String jobCode, String jobType, String jobTitle, String jobDescription, double salary, String managerID, String managerTitle) {
        boolean blnUpdateEmployee= false;
        Long employeeID = 0L;

        Iterable<Employee> employees = repositoryEmployee.findAll();
        for (Employee employee : employees) {
            if (employee.getIDNumber().equalsIgnoreCase(idNumber))
            {
                employeeID = employee.getID();
                blnUpdateEmployee = true;
            }
        }

        if (blnUpdateEmployee == true)
        {
            Employee employee = repositoryEmployee.findOne(employeeID);

            Employee newEmployee = new Employee.Builder(employee.getIDNumber())
                    .ID(employeeID)
                    .employee_firstnames("John")
                    .employee_lastname("Dave")
                    .build();
            repositoryEmployee.save(newEmployee);
        }
        return blnUpdateEmployee;
    }
}