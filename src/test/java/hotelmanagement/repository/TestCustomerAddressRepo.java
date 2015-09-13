package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.CustomerAddress;
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
public class TestCustomerAddressRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    CustomerAddressRepo repository;
    @Test
    public void testCreate() throws Exception {
        CustomerAddress customerAddress = new CustomerAddress.Builder("51 Red")
                .postal_address("51 Red")
                .postal_code("7941")
                .build();
        repository.save(customerAddress);
        id = customerAddress.getID();
        Assert.assertNotNull(customerAddress);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        CustomerAddress customerAddress = repository.findOne(id);
        Assert.assertEquals("51 Red", customerAddress.getPhysicalAddress());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        CustomerAddress customerAddress = repository.findOne(id);
        CustomerAddress newCustomerAddress = new CustomerAddress.Builder(customerAddress.getPhysicalAddress())
                .ID(id)
                .postal_address("51 Red")
                .postal_code("P.O Box 7941")
                .build();
        repository.save(newCustomerAddress);

        CustomerAddress updatedCustomerAddress = repository.findOne(id);
        Assert.assertEquals("51 Red", updatedCustomerAddress.getPostalAddress());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        CustomerAddress customerAddress = repository.findOne(id);
        repository.delete(customerAddress);
        CustomerAddress newCustomerAddress = repository.findOne(id);
        Assert.assertNull(newCustomerAddress);
    }
}
