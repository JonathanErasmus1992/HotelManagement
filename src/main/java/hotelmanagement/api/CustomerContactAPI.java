package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */
import hotelmanagement.domain.CustomerContact;
import hotelmanagement.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/ccontact/**")
public class CustomerContactAPI {
    @Autowired
    CustomerContactService customerContactService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerContact>> getAllCustomerContacts()
    {
        List<CustomerContact> customerContactList = customerContactService.getAllCustomerContacts();

        return new ResponseEntity<List<CustomerContact>>(customerContactList, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateCustomerContact(@RequestParam String cellNumber,
                                                         @RequestParam String homeNumber,
                                                         @RequestParam String emailAddress,
                                                         @RequestParam String NOKN)
    {
        boolean blnContactUpdated = false;

        blnContactUpdated = customerContactService.updateCustomerContact(cellNumber, homeNumber, emailAddress, NOKN);

        return new ResponseEntity<Boolean>(blnContactUpdated, HttpStatus.OK);
    }
}
