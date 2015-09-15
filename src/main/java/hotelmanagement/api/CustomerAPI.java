package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */
import hotelmanagement.domain.Customer;
import hotelmanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer/**")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        List<Customer> customerList = customerService.getAllCustomers();

        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createCustomer(@RequestParam String idNumber,
                                                  @RequestParam String firstName,
                                                  @RequestParam String lastName,
                                                  @RequestParam String physicalAddress,
                                                  @RequestParam String postalAddress,
                                                  @RequestParam String postalCode,
                                                  @RequestParam String cellNumber,
                                                  @RequestParam String homeNumber,
                                                  @RequestParam String emailAddress,
                                                  @RequestParam String NOKN)
    {
        boolean blnCustomerCreated = false;

        blnCustomerCreated = customerService.createCustomer(idNumber, firstName, lastName, physicalAddress, postalAddress, postalCode, cellNumber, homeNumber, emailAddress, NOKN);

        return new ResponseEntity<Boolean>(blnCustomerCreated, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateCustomer(@RequestParam String idNumber,
                                                  @RequestParam String firstName,
                                                  @RequestParam String lastName)
    {
        boolean blnCustomerUpdated = false;

        blnCustomerUpdated = customerService.updateCustomer(idNumber, firstName, lastName,
                "", "", "", "", "", "","");

        return new ResponseEntity<Boolean>(blnCustomerUpdated, HttpStatus.OK);
    }
}
