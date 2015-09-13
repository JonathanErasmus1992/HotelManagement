package hotelmanagement.repository;

import hotelmanagement.App;
import hotelmanagement.domain.ServicesAndAddOns;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/09/09.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestServicesAndAddOnsRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    ServicesAndAddOnsRepo repository;
    @Test
    public void testCreate() throws Exception {
        ServicesAndAddOns servicesAndAddOns = new ServicesAndAddOns.Builder(1)
                .extra_name("Mini Bar")
                .price_added(200.00)
                .build();
        repository.save(servicesAndAddOns);
        id = servicesAndAddOns.getID();
        Assert.assertNotNull(servicesAndAddOns);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        ServicesAndAddOns servicesAndAddOns = repository.findOne(id);
        Assert.assertEquals(1, servicesAndAddOns.getServExtraID());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        ServicesAndAddOns servicesAndAddOns =   repository.findOne(id);
        ServicesAndAddOns newServicesAndAddOns = new ServicesAndAddOns.Builder(servicesAndAddOns.getServExtraID())
                .ID(id)
                .extra_name("Mini Fridge")
                .price_added(200.00)
                .build();
        repository.save(newServicesAndAddOns);

        ServicesAndAddOns updateServicesAndAddOns = repository.findOne(id);
        Assert.assertEquals("Mini Fridge", updateServicesAndAddOns.getExtraName());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        ServicesAndAddOns servicesAndAddOns = repository.findOne(id);
        repository.delete(servicesAndAddOns);
        ServicesAndAddOns newServicesAndAddOns = repository.findOne(id);
        Assert.assertNull(newServicesAndAddOns);
    }
}
