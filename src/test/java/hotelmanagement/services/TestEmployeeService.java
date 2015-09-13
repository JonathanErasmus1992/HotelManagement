package hotelmanagement.services;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.App;
import hotelmanagement.domain.Employee;
import hotelmanagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestEmployeeService extends AbstractTestNGSpringContextTests{
    @Autowired
    private EmployeeService service;
    private List<Employee> employeeList;
    private Long id;

    @Autowired
    private EmployeeRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllEmployees()
    {
        long count = repository.count();
        employeeList = service.getAllEmployees();
        Assert.assertTrue(employeeList.size() == count);
    }

    @Test
    public void testCreateEmployee()
    {
        //Must change the id number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Date hireDate = new Date();
        Assert.assertFalse(service.createEmployee("921105", "Sam", "Smith", hireDate, "Couloured", "Male",
                "English", "51 Redd Lo", "PO Box", "7941", "0865432357", "088", "email",
                "021", "022", "Clerk", "HR", "Desk", 400.00,
                "001", "CFO"));
    }

    @Test
    public void testUpdateEmployee()
    {
        Date hireDate = new Date();
        Assert.assertFalse(service.createEmployee("921105", "Sam", "Smith", hireDate, "Couloured", "Male",
                "English", "51 Redd Lo", "PO Box", "7941", "0865432357", "088", "email",
                "021", "022", "Clerk", "HR", "Desk", 400.00,
                "001", "CEO"));
    }
}
