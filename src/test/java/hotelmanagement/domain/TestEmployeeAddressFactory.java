package hotelmanagement.domain;

import hotelmanagement.conf.EmployeeAddressFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestEmployeeAddressFactory {
    private EmployeeAddress empAdd;
    private EmployeeAddress newEmpAdd;
    @Before
    public void setUp()
    {
        empAdd = EmployeeAddressFactory.createCustomerAddress("DDD", "EEE", "011");
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("DDD", empAdd.getPhysicalAddress());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newEmpAdd = new EmployeeAddress
                .Builder(empAdd.getPhysicalAddress())
                .copy(empAdd)
                .postal_address("FFF")
                .build();
        Assert.assertEquals("DDD", newEmpAdd.getPhysicalAddress());
        Assert.assertEquals("FFF", newEmpAdd.getPostalAddress());
    }
    @After
    public void tearDown()
    {

    }
}
