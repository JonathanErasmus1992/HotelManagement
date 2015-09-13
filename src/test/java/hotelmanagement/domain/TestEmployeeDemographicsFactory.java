package hotelmanagement.domain;

import hotelmanagement.conf.EmployeeDemographicsFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestEmployeeDemographicsFactory {
    private EmployeeDemographics empDemo;
    private EmployeeDemographics newEmpDemo;
    @Before
    public void setUp()
    {
        empDemo = EmployeeDemographicsFactory.createEmployeeDemographics("Male", "White", "English");
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("Male", empDemo.getGender());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newEmpDemo = new EmployeeDemographics
                .Builder(empDemo.getRace())
                .copy(empDemo)
                .gender("Female")
                .build();
        Assert.assertEquals("White", newEmpDemo.getRace());
        Assert.assertEquals("Female", newEmpDemo.getGender());
    }
    @After
    public void tearDown()
    {

    }
}
