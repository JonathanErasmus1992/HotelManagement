package hotelmanagement.domain;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.conf.CustomerBookingFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;

public class TestCustomerBookingFactory {
    private CustomerBooking customerBooking;
    private CustomerBooking newCustomerBooking;
    @Before
    public void setUp() {
        customerBooking = CustomerBookingFactory.createCustomerBooking("01234", "9000", "Johnny", "Boy");
    }
    @Test
    public void testCreate()
    {
        Assert.assertEquals("01234", customerBooking.getReferenceNumber());
    }
    public void testUpdate()
    {
        newCustomerBooking = new CustomerBooking
                .Builder(customerBooking.getReferenceNumber())
                .idNumber("9000")
                .firstNames("Johnny")
                .lastName("Drama")
                .build();
        Assert.assertEquals("01234", newCustomerBooking.getReferenceNumber());
        Assert.assertEquals("Drama", newCustomerBooking.getLastName());
    }
    @After
    public void tearDown()
    {

    }
}
