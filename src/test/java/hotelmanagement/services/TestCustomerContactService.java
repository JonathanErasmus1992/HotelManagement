package hotelmanagement.services;

/**
 * Created by student on 2015/09/12.
 */
import hotelmanagement.App;
import hotelmanagement.domain.CustomerContact;
import hotelmanagement.repository.CustomerContactRepo;
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
public class TestCustomerContactService extends AbstractTestNGSpringContextTests{
    @Autowired
    private CustomerContactService service;
    private List<CustomerContact> customerContactList;
    private Long id;

    @Autowired
    private CustomerContactRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllCustomerContacts()
    {
        long count = repository.count();
        customerContactList = service.getAllCustomerContacts();
        Assert.assertTrue(customerContactList.size() == count);
    }

    @Test
    public void testCreateCustomerContact()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.createCustomerContact("0766750472", "0217050239", "jonathanerasmus1992@gmail.com", "0780797809"));
    }

    @Test
    public void testUpdateCustomerContact()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.updateCustomerContact("0766750472", "0217050230", "jonathanerasmus1992@gmail.com", "0780797809"));
    }
}
