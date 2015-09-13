package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/09/09.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestEmployeeRepo extends AbstractTestNGSpringContextTests {
    private Long id;
    private List<EmployeeDemographics> employee_demographics;
    private List<EmployeeAddress> employee_address;
    private List<EmployeeContact> employee_contact;
    private List<Job> job;
    private List<Manager> manager;
    private Date date;

    @Autowired
    EmployeeRepo repository;
    @Test
    public void testCreate() throws Exception {
        Employee employee = new Employee.Builder("9211045171083")
                .employee_firstnames("John")
                .employee_lastname("Erasmus")
                .employee_demographics(employee_demographics)
                .employee_address(employee_address)
                .employee_contact(employee_contact)
                .job(job)
                .manager(manager)
                .hire_date(date)
                .build();
        repository.save(employee);
        id = employee.getID();
        Assert.assertNotNull(employee);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        Employee employee = repository.findOne(id);
        Assert.assertEquals("9211045171083", employee.getIDNumber());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        Employee employee = repository.findOne(id);
        Employee newEmployee = new Employee.Builder(employee.getIDNumber())
                .ID(id)
                .employee_firstnames("John")
                .employee_lastname("Dave")
                .employee_demographics(employee_demographics)
                .employee_address(employee_address)
                .employee_contact(employee_contact)
                .job(job)
                .manager(manager)
                .hire_date(date)
                .build();
        repository.save(newEmployee);

        Employee updatedEmployee = repository.findOne(id);
        Assert.assertEquals("Dave", updatedEmployee.getLastname());

    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        Employee employee = repository.findOne(id);
        repository.delete(employee);
        Employee newEmployee = repository.findOne(id);
        Assert.assertNull(newEmployee);
    }
}
