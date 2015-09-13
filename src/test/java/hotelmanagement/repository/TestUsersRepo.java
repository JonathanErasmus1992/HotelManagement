package hotelmanagement.repository;

import hotelmanagement.App;
import hotelmanagement.domain.User;
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
public class TestUsersRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    UserRepo repository;
    @Test
    public void testCreate() throws Exception {
        User user = new User.Builder("jonathanerasmus1992@gmail.com")
                .password("1325")
                .recoveryQuestion("1 + 1")
                .recoveryAnswer("3")
                .build();
        repository.save(user);
        id = user.getID();
        Assert.assertNotNull(user);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        User user = repository.findOne(id);
        Assert.assertEquals("jonathanerasmus1992@gmail.com", user.getEmailAddress());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        User user = repository.findOne(id);
        User newUser = new User.Builder(user.getEmailAddress())
                .ID(id)
                .password("2580")
                .recoveryQuestion("1 + 1")
                .recoveryAnswer("3")
                .build();
        repository.save(newUser);
        User updatedUser = repository.findOne(id);
        Assert.assertEquals("2580", updatedUser.getPassword());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        User user = repository.findOne(id);
        repository.delete(user);
        User newUser = repository.findOne(id);
        Assert.assertNull(newUser);
    }
}
