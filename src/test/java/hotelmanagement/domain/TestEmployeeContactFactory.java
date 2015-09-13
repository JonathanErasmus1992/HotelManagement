package hotelmanagement.domain;

import hotelmanagement.conf.EmployeeContactFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestEmployeeContactFactory {
    private EmployeeContact empCon;
    private EmployeeContact newEmpCon;
    @Before
    public void setUp()
    {
        empCon = EmployeeContactFactory.createCustomerContact("083", "021", "gmail", "076");
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("083", empCon.getCellNumber());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newEmpCon = new EmployeeContact
                .Builder(empCon.getCellNumber())
                .copy(empCon)
                .home_number("022")
                .build();
        Assert.assertEquals("083", newEmpCon.getCellNumber());
        Assert.assertEquals("022", newEmpCon.getHomeNumber());
    }
    @After
    public void tearDown()
    {

    }
}
