package hotelmanagement.services;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.App;
import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestBookingService extends AbstractTestNGSpringContextTests{
    @Autowired
    private BookingService service;
    private List<Booking> bookingList;
    private List<Room> roomList;
    private List<ServicesAndAddOns> servicesAndAddOnsList;
    private Date hireDate = new Date();
    private Long id;

    @Autowired
    private BookingRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void getAllBookings()
    {
        long count = repository.count();
        bookingList = service.getAllBookings();
        Assert.assertTrue(bookingList.size() == count);
    }

    @Test
    public void testCreateBooking()
    {
        //Must change the first field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        //Assert.assertFalse(service.createBooking("777", roomList, servicesAndAddOnsList, hireDate));
    }

    @Test
    public void testDeleteBooking()
    {
        //Must change the first field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        //Assert.assertTrue(service.deleteBooking("777"));
    }
}
