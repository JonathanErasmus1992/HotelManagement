package hotelmanagement.domain;

import hotelmanagement.conf.ServicesAndAddOnsFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestServicesAndAddOnsFactory {
    private ServicesAndAddOns servicesAndAddOns;
    private ServicesAndAddOns newServicesAndAddons;
    @Before
    public void setUp()
    {
        servicesAndAddOns = ServicesAndAddOnsFactory.createServicesAndAddOns( 1234, "Fluffy pillow", 23.00);
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals(1234, servicesAndAddOns.getServExtraID());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newServicesAndAddons = new ServicesAndAddOns
                .Builder(servicesAndAddOns.getServExtraID())
                .copy(servicesAndAddOns)
                .price_added(45.00)
                .build();
        Assert.assertEquals(1234, newServicesAndAddons.getServExtraID());
        Assert.assertEquals(45.00, newServicesAndAddons.getPriceAdded());
    }
    @After
    public void tearDown()
    {

    }
}

