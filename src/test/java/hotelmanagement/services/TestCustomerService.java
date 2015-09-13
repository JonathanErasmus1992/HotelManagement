package hotelmanagement.services;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.App;
import hotelmanagement.domain.Customer;
import hotelmanagement.repository.CustomerRepo;
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
public class TestCustomerService extends AbstractTestNGSpringContextTests{
    @Autowired
    private CustomerService service;
    private List<Customer> customerList;
    private Long id;

    @Autowired
    private CustomerRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllCustomers()
    {
        long count = repository.count();
        customerList = service.getAllCustomers();
        Assert.assertTrue(customerList.size() == count);
    }

    @Test
    public void testCreateCustomer()
    {
        //Must change the customer id to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.createCustomer("1234", "John", "Dave", "35 Lotus", "Same As Physical",
                "7941", "0845674527", "0213333333", "jonnyboy@gmail.com", "0216666666"));
    }

    @Test
    public void testUpdateCustomer()
    {
        //Must change the contact id field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.updateCustomer("1234", "John", "Dave", "35 Lotus", "Same As Physical",
                "7941", "0845674527", "0213333333", "jonnyboy@gmail.com", "0216666666"), repository.toString());
    }
}
