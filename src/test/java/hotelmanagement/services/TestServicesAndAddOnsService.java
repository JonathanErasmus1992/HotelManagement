package hotelmanagement.services;

/**
 * Created by student on 2015/09/12.
 */
import hotelmanagement.App;
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.repository.ServicesAndAddOnsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestServicesAndAddOnsService extends AbstractTestNGSpringContextTests{

    @Autowired
    private ServicesAndAddOnsService service;
    private List<ServicesAndAddOns> servicesAndAddOnsList;
    private Long id;

    @Autowired
    private ServicesAndAddOnsRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllServicesAndAddOns()
    {
        long count = repository.count();
        servicesAndAddOnsList = service.getAllServicesAndAddOns();
        Assert.assertTrue(servicesAndAddOnsList.size() == count);
    }

    @Test
    public void testCreateServicesAndAddOns()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.createServicesAndAddOns(0, "Mini Bar", 200));
    }

    @Test
    public void testUpdateServicesAndAddOns()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.updateServicesAndAddOns(0, "Mini Bar", 200));
    }

    @Test
    public void testDeleteServicesAndAddOns()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.deleteServicesAndAddOns(0));
    }
}
