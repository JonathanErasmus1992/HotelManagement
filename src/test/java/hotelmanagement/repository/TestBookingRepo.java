package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Dates;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/09/09.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestBookingRepo extends AbstractTestNGSpringContextTests {
    private Long id;
    private String rooms = "Blue";
    private String roomEX = "Green";
    private String services_and_addons = "Navy";
    private Date date = new Date();
    @Autowired
    BookingRepo repository;
    @Test
    public void testCreate() throws Exception {
        Booking booking = new Booking.Builder("1234")
                .rooms(rooms)
                .services_and_addons(services_and_addons)
                .hireDate(date)
                .build();
        repository.save(booking);
        id = booking.getID();
        Assert.assertNotNull(booking);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        Booking booking = repository.findOne(id);
        Assert.assertEquals("1234", booking.getReferenceNumber());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {

        Booking booking = repository.findOne(id);
        Booking newBooking = new Booking.Builder(booking.getReferenceNumber())
                .ID(id)
                .rooms(roomEX)
                .services_and_addons(services_and_addons)
                .hireDate(date)
                .build();
        repository.save(newBooking);

        Booking updatedBooking = repository.findOne(id);
        Assert.assertEquals("Green", roomEX);
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        Booking booking = repository.findOne(id);
        repository.delete(booking);
        Booking newBooking = repository.findOne(id);
        Assert.assertNull(newBooking);
    }
}

