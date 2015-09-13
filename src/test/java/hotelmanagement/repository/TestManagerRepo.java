package hotelmanagement.repository;

import hotelmanagement.App;
import hotelmanagement.domain.Manager;

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
public class TestManagerRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    ManagerRepo repository;
    @Test
    public void testCreate() throws Exception {
        Manager manager = new Manager.Builder("man1")
                .manager_title("CEO")
                .build();
        repository.save(manager);
        id = manager.getID();
        Assert.assertNotNull(manager);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        Manager manager = repository.findOne(id);
        Assert.assertEquals("man1", manager.getManagerID());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        Manager manager = repository.findOne(id);
        Manager newManager = new Manager.Builder(manager.getManagerID())
                .ID(id)
                .manager_title("CFO")
                .build();
        repository.save(newManager);

        Manager updatedUser = repository.findOne(id);
        Assert.assertEquals("CFO", updatedUser.getManagerTitle());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        Manager manager = repository.findOne(id);
        repository.delete(manager);
        Manager newManager = repository.findOne(id);
        Assert.assertNull(newManager);
    }
}
