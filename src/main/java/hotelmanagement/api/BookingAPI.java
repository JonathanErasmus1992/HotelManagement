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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
                                                 @RequestParam String rooms,
                                                 @RequestParam String servicesAndExtras,
                                                 @RequestParam String strHireDate)
    {
        boolean blnBookingCreated = false;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = new Date();

        try{
            hireDate = format.parse(strHireDate);
        }
        catch(ParseException pe)
        {
            String errorMessage = "Error: " + pe.toString();
        }

        blnBookingCreated = bookingService.createBooking(referenceNumber, rooms, servicesAndExtras, hireDate);

        return new ResponseEntity<Boolean>(blnBookingCreated, HttpStatus.OK);
    }

    //Update booking only allowed to remove Rooms
    //Or remove ServiceAndExtras from the Booking lists
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateBooking(@RequestParam String referenceNumber,
                                                 @RequestParam String rooms,
                                                 @RequestParam String servicesAndExtras)
    {
        boolean blnUpdateBooking = false;

        blnUpdateBooking = bookingService.updateBooking(referenceNumber, rooms, servicesAndExtras);

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
