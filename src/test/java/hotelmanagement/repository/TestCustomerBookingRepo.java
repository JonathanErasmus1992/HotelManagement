package hotelmanagement.repository;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.App;
import hotelmanagement.domain.CustomerBooking;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCustomerBookingRepo extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private CustomerBookingRepo repository;

    @Test
    public void testCreate() throws Exception {
        CustomerBooking customerBooking = new CustomerBooking.Builder("09876")
                .idNumber("111")
                .firstNames("Jon")
                .lastName("Dave")
                .build();
        repository.save(customerBooking);
        id = customerBooking.getId();
        Assert.assertNotNull(customerBooking);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        CustomerBooking customerBooking = repository.findOne(id);
        Assert.assertEquals("Dave", customerBooking.getLastName());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        CustomerBooking customerBooking = repository.findOne(id);
        CustomerBooking newCustomerBooking = new CustomerBooking.Builder(customerBooking.getReferenceNumber())
                .id(id)
                .idNumber("111")
                .firstNames("John")
                .lastName("Dave")
                .build();
        repository.save(newCustomerBooking);

        CustomerBooking updatedCustomerBooking = repository.findOne(id);
        Assert.assertEquals("John", updatedCustomerBooking.getFirstNames());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        CustomerBooking booking = repository.findOne(id);
        repository.delete(booking);
        CustomerBooking newCustomerBooking = repository.findOne(id);
        Assert.assertNull(newCustomerBooking);
    }
}
