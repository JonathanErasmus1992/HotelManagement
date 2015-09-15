package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */

import hotelmanagement.domain.CustomerBooking;
import hotelmanagement.services.CustomerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/makebooking/**")
public class MakeBookingAPI {
    @Autowired
    private CustomerBookingService customerBookingService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerBooking>> getAllCustomerBookings()
    {
        List<CustomerBooking> customerBookingList = customerBookingService.getAllCustomerBookings();

        return new ResponseEntity<List<CustomerBooking>>(customerBookingList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createCustomerBooking(@RequestParam String referenceNumber,
                                                         @RequestParam String idNumber,
                                                         @RequestParam String firstNames,
                                                         @RequestParam String lastName)
    {
        boolean blnCustomerBookingCreated = false;

        blnCustomerBookingCreated = customerBookingService.createCustomerBooking(referenceNumber, idNumber, firstNames, lastName);

        return new ResponseEntity<Boolean>(blnCustomerBookingCreated, HttpStatus.OK);
    }

}
