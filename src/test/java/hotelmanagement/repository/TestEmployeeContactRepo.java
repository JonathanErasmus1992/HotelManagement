package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.EmployeeContact;
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
public class TestEmployeeContactRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    EmployeeContactRepo repository;
    @Test
    public void testCreate() throws Exception {
        EmployeeContact employeeContact = new EmployeeContact.Builder("076 675 0472")
                .home_number("021 705 0239")
                .email_address("jonathanerasmus1992@gmail.com")
                .next_of_kin_contact("078 079 7809")
                .build();
        repository.save(employeeContact);
        id = employeeContact.getID();
        Assert.assertNotNull(employeeContact);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        EmployeeContact employeeContact = repository.findOne(id);
        Assert.assertEquals("076 675 0472", employeeContact.getCellNumber());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        EmployeeContact employeeContact = repository.findOne(id);
        EmployeeContact newEmployeeContact = new EmployeeContact.Builder(employeeContact.getCellNumber())
                .home_number("021 705 0239")
                .email_address("jonathanerasmus1992@gmail.com")
                .next_of_kin_contact("078 079 7878")
                .build();
        repository.save(newEmployeeContact);

        EmployeeContact updateEmployeeContact = repository.findOne(id);
        Assert.assertEquals("078 079 7809", updateEmployeeContact.getNextOfKinContact());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        EmployeeContact employeeContact = repository.findOne(id);
        repository.delete(employeeContact);
        EmployeeContact newEmployeeContact = repository.findOne(id);
        Assert.assertNull(newEmployeeContact);
    }
}
