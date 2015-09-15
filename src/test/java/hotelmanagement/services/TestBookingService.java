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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestBookingService extends AbstractTestNGSpringContextTests{
    @Autowired
    private BookingService service;
    private List<Booking> bookingList;
    private List<Room> roomList = new ArrayList<Room>();
    private List<ServicesAndAddOns> servicesAndAddOnsList = new ArrayList<ServicesAndAddOns>();
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
        /*Room room = new Room.Builder(1738)
                .room_type("Couple Suite")
                .room_view("Ocean")
                .room_price(300.00)
                .build();

        ServicesAndAddOns servicesAndAddOns = new ServicesAndAddOns.Builder(1738)
                .extra_name("Horror Horror and Horror")
                .price_added(200.00)
                .build();

        roomList.add(room);
        servicesAndAddOnsList.add(servicesAndAddOns);
        //Must change the first field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.createBooking("777", roomList, servicesAndAddOnsList, hireDate));
        */
    }

    @Test
    public void testUpdateBooking()
    {
        //Must change the first field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        //Assert.assertFalse(service.updateBooking("777", 1738, 1738));
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
