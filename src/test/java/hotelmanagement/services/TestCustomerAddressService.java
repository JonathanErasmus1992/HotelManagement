package hotelmanagement.services;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.App;
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.repository.CustomerAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCustomerAddressService extends AbstractTestNGSpringContextTests{
    @Autowired
    private CustomerAddressService service;
    private List<CustomerAddress> customerAddressList;
    private Long id;

    @Autowired
    private CustomerAddressRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllCustomerAddresses()
    {
        long count = repository.count();
        customerAddressList = service.getAllCustomerAddresses();
        Assert.assertTrue(customerAddressList.size() == count);
    }

    @Test
    public void testCreateCustomerAddress()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.createCustomerAddress("51 Reddy Ave", "Same As Physical", "7941"));
    }

    @Test
    public void testUpdateCustomerAddress()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.updateCustomerAddress("51 Reddy Ave", "51 Reddy Ave", "7941"));
    }
}
