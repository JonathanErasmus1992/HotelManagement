package hotelmanagement.domain;

import hotelmanagement.conf.CustomerAddressFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestCustomerAddressFactory {
    private CustomerAddress custAdd;
    private CustomerAddress newCustAdd;
    @Before
    public void setUp()
    {
        custAdd = CustomerAddressFactory.createCustomerAddress("AAA", "BBB", "111");
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("AAA", custAdd.getPhysicalAddress());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newCustAdd = new CustomerAddress
                .Builder(custAdd.getPhysicalAddress())
                .copy(custAdd)
                .postal_address("CCC")
                .build();

        Assert.assertEquals("AAA", newCustAdd.getPhysicalAddress());
        Assert.assertEquals("CCC", newCustAdd.getPostalAddress());
    }
    @After
    public void tearDown()
    {

    }
}
