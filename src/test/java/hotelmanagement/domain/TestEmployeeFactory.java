package hotelmanagement.domain;

import hotelmanagement.conf.EmployeeFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.Date;

/**
 * Created by student on 2015/05/05.
 */
public class TestEmployeeFactory {
    private Employee emp;
    private Employee newEmp;
    private Date d;
    @Before
    public void setUp()
    {
        emp = EmployeeFactory.createEmployee("921", "John", "Doe", null, null, null, null, null, d);
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("921", emp.getIDNumber());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newEmp = new Employee
                .Builder(emp.getIDNumber())
                .copy(emp)
                .employee_firstnames("John D")
                .build();
        Assert.assertEquals("921", newEmp.getIDNumber());
        Assert.assertEquals("John D", newEmp.getFirstnames());
    }
    @After
    public void tearDown()
    {

    }
}
