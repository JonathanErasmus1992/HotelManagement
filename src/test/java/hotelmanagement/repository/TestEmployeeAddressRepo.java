package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.EmployeeAddress;
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
public class TestEmployeeAddressRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    EmployeeAddressRepo repository;
    @Test
    public void testCreate() throws Exception {
        EmployeeAddress employeeAddress = new EmployeeAddress.Builder("51 Reddy Ave Grassy Park")
                .postal_address("51 Reddy Ave Grassy Park")
                .postal_code("7941")
                .build();
        repository.save(employeeAddress);
        id = employeeAddress.getID();
        Assert.assertNotNull(employeeAddress);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        EmployeeAddress employeeAddress = repository.findOne(id);
        Assert.assertEquals("51 Reddy Ave Grassy Park", employeeAddress.getPhysicalAddress());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        EmployeeAddress employeeAddress = repository.findOne(id);
        EmployeeAddress newEmployeeAddress = new EmployeeAddress.Builder(employeeAddress.getPhysicalAddress())
                .ID(id)
                .postal_address("P.O Box 7941")
                .postal_code("7941")
                .build();
        repository.save(newEmployeeAddress);

        EmployeeAddress updatedEmployeeAddress = repository.findOne(id);
        Assert.assertEquals("P.O Box 7941",updatedEmployeeAddress.getPostalAddress());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        EmployeeAddress employeeAddress = repository.findOne(id);
        repository.delete(employeeAddress);
        EmployeeAddress newEmployeeAddress = repository.findOne(id);
        Assert.assertNull(newEmployeeAddress);
    }
}
