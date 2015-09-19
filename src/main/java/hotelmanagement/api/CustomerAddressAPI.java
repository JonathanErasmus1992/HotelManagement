package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.services.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/caddress/**")
public class CustomerAddressAPI {
    @Autowired
    private CustomerAddressService customerAddressService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerAddress>> getAllCustomerAddresses()
    {
        List<CustomerAddress> customerAddressList = customerAddressService.getAllCustomerAddresses();

        return new ResponseEntity<List<CustomerAddress>>(customerAddressList, HttpStatus.OK);
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateCustomerAddress(@RequestParam String physicalAddress,
                                                         @RequestParam String postalAddress,
                                                         @RequestParam String postalCode)
    {
        boolean blnAddressUpdated = false;

        blnAddressUpdated = customerAddressService.updateCustomerAddress(physicalAddress, postalAddress, postalCode);

        return new ResponseEntity<Boolean>(blnAddressUpdated, HttpStatus.OK);
    }


}
