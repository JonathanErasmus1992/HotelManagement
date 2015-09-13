package hotelmanagement.domain;

import hotelmanagement.conf.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestUserFactory {
    private User user;
    private User newUser;
    @Before
    public void setUp()
    {
        user = UserFactory.createUser("email@address", "1234", "1 + 1", "3");

    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("email@address", user.getEmailAddress());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newUser = new User
                .Builder(user.getEmailAddress())
                .copy(user)
                .password("4321")
                .build();
        Assert.assertEquals("email@address", newUser.getEmailAddress());
        Assert.assertEquals("4321", newUser.getPassword());
    }
    @After
    public void tearDown()
    {

    }
}
