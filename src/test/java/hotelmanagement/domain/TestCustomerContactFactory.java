package hotelmanagement.domain;

import hotelmanagement.conf.CustomerContactFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestCustomerContactFactory {
    private CustomerContact custCon;
    private CustomerContact newCustCon;
    @Before
    public void setUp()
    {
        custCon = CustomerContactFactory.createCustomerContact("083", "021", "gmail", "076");
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("083", custCon.getCellNumber());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newCustCon = new CustomerContact
                .Builder(custCon.getCellNumber())
                .copy(custCon)
                .home_number("022")
                .build();
        Assert.assertEquals("083", newCustCon.getCellNumber());
        Assert.assertEquals("022", newCustCon.getHomeNumber());
    }
    @After
    public void tearDown()
    {

    }
}
