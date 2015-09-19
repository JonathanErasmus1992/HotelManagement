package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */
import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/booking/**")
public class BookingAPI {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Booking>> getAllBookings()
    {
        List<Booking> bookingList = bookingService.getAllBookings();

        return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
    }

    //Create a new booking. Booking can only be updated by deleting specific rooms or services from their
    //respective lists
    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createBooking(@RequestParam String referenceNumber,
                                                 @RequestParam List<Room> roomList,
                                                 @RequestParam List<ServicesAndAddOns> servicesAndAddOnsList,
                                                 @RequestParam Date hireDate)
    {
        boolean blnBookingCreated = false;

        blnBookingCreated = bookingService.createBooking(referenceNumber, roomList, servicesAndAddOnsList, hireDate);

        return new ResponseEntity<Boolean>(blnBookingCreated, HttpStatus.OK);
    }

    //Update booking only allowed to remove Rooms
    //Or remove ServiceAndExtras from the Booking lists
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateBooking(@RequestParam String referenceNumber,
                                                 @RequestParam int roomNumber,
                                                 @RequestParam int SEID)
    {
        boolean blnUpdateBooking = false;

        blnUpdateBooking = bookingService.updateBooking(referenceNumber, roomNumber, SEID);

        return new ResponseEntity<Boolean>(blnUpdateBooking, HttpStatus.OK);

    }

    //Delete Booking
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteBooking(@RequestParam String referenceNumber)
    {
        boolean blnDeleteBooking = false;

        blnDeleteBooking = bookingService.deleteBooking(referenceNumber);

        return new ResponseEntity<Boolean>(blnDeleteBooking, HttpStatus.OK);
    }

}
