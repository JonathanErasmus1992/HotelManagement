package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.CustomerContact;
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
public class TestCustomerContactRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    CustomerContactRepo repository;
    @Test
    public void testCreate() throws Exception {
        CustomerContact customerContact = new CustomerContact.Builder("0766750472")
                .home_number("021 705 0239")
                .email_address("zanevalentine.je@gmail.com")
                .next_of_kin_contact("021 7050239")
                .build();
        repository.save(customerContact);
        id = customerContact.getID();
        Assert.assertNotNull(customerContact);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        CustomerContact customerContact = repository.findOne(id);
        Assert.assertEquals("0766750472", customerContact.getCellNumber());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        CustomerContact customerContact = repository.findOne(id);
        CustomerContact newCustomerContact = new CustomerContact.Builder(customerContact.getCellNumber())
                .ID(id)
                .home_number("021 705 0239")
                .email_address("zanevalentine.je@gmail.com")
                .next_of_kin_contact("0217050239")
                .build();
        repository.save(newCustomerContact);

        CustomerContact updatedCustomerContact = repository.findOne(id);
        Assert.assertEquals("0217050239", updatedCustomerContact.getNextOfKinContact());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        CustomerContact customerContact = repository.findOne(id);
        repository.delete(customerContact);
        CustomerContact newCustomerContact = repository.findOne(id);
        Assert.assertNull(newCustomerContact);
    }
}
