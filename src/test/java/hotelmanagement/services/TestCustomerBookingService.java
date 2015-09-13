package hotelmanagement.services;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.App;
import hotelmanagement.domain.CustomerBooking;
import hotelmanagement.repository.CustomerBookingRepo;
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
public class TestCustomerBookingService extends AbstractTestNGSpringContextTests{
    @Autowired
    private CustomerBookingService service;
    private List<CustomerBooking> customerBookingList;
    private Long id;

    @Autowired
    private CustomerBookingRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllCustomerBookings()
    {
        long count = repository.count();
        customerBookingList = service.getAllCustomerBookings();
        Assert.assertTrue(customerBookingList.size() == count);
    }

    @Test
    public void testCreateCustomerBooking()
    {
        //Must change the first field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue

        //Assert.assertFalse(service.createCustomerBooking("12345", "921104", "Liam", "Isaacs"));
    }

    @Test
    public void testDeleteCustomerBooking()
    {
        //Must change the first field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue

        //Assert.assertTrue(service.deleteCustomerBooking("12345"));
    }
}
