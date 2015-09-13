package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.Customer;
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.domain.CustomerContact;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by student on 2015/09/09.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCustomerRepo extends AbstractTestNGSpringContextTests {
    private Long id;
    private List<CustomerAddress> customerAddresses;
    private List<CustomerContact> customerContacts;

    @Autowired
    CustomerRepo repository;
    @Test
    public void testCreate() throws Exception {
        Customer customer = new Customer.Builder("9211045171083")
                .customer_firstnames("Jon")
                .customer_lastname("Davids")
                .customer_address(customerAddresses)
                .customer_contact(customerContacts)
                .build();
        repository.save(customer);
        id = customer.getID();
        Assert.assertNotNull(customer);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        Customer customer = repository.findOne(id);
        Assert.assertEquals("9211045171083", customer.getIDNumber());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        Customer customer = repository.findOne(id);
        Customer newCustomer = new Customer.Builder(customer.getIDNumber())
                .ID(id)
                .customer_firstnames("Jon")
                .customer_lastname("David")
                .customer_address(customerAddresses)
                .customer_contact(customerContacts)
                .build();
        repository.save(newCustomer);

        Customer updatedCustomer = repository.findOne(id);
        Assert.assertEquals("David", updatedCustomer.getLastname());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        Customer customer = repository.findOne(id);
        repository.delete(customer);
        Customer newCustomer = repository.findOne(id);
        Assert.assertNull(newCustomer);
    }
}
