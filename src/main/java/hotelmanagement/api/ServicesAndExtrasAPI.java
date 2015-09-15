package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.services.ServicesAndAddOnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/servicesandextras/**")
public class ServicesAndExtrasAPI {
    @Autowired
    ServicesAndAddOnsService servicesAndAddOnsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServicesAndAddOns>> getAllServicesAndAddOns()
    {
        List<ServicesAndAddOns> servicesAndAddOnsList = servicesAndAddOnsService.getAllServicesAndAddOns();

        return new ResponseEntity<List<ServicesAndAddOns>>(servicesAndAddOnsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createServiceAndExtra(@RequestParam int SEID,
                                                         @RequestParam String extraName,
                                                         @RequestParam double price)
    {
        boolean blnServiceAndExtraCreated = false;

        blnServiceAndExtraCreated = servicesAndAddOnsService.createServicesAndAddOns(SEID, extraName, price);

        return new ResponseEntity<Boolean>(blnServiceAndExtraCreated, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateServiceAndExtra(@RequestParam int SEID,
                                                         @RequestParam String extraName,
                                                         @RequestParam double price)
    {
        boolean blnServiceAndExtraUpdated = false;

        blnServiceAndExtraUpdated = servicesAndAddOnsService.updateServicesAndAddOns(SEID, extraName, price);

        return new ResponseEntity<Boolean>(blnServiceAndExtraUpdated, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteServiceAndExtra(@RequestParam int SEID)
    {
        boolean blnServiceAndExtraDeleted = false;

        blnServiceAndExtraDeleted = servicesAndAddOnsService.deleteServicesAndAddOns(SEID);

        return new ResponseEntity<Boolean>(blnServiceAndExtraDeleted, HttpStatus.OK);
    }
}
