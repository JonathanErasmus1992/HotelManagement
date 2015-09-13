package hotelmanagement.services;

/**
 * Created by student on 2015/09/12.
 */
import hotelmanagement.App;

import hotelmanagement.domain.User;
import hotelmanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class TestUserService extends AbstractTestNGSpringContextTests{
    @Autowired
    private UserService service;
    private List<User> users;
    private Long id;

    @Autowired
    private UserRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {
        User user = new User.Builder("jonathanerasmus1992@gmail.com")
                .password("1325")
                .recoveryQuestion("1 + 1")
                .recoveryAnswer("3")
                .build();
        repository.save(user);
        id = user.getID();
    }

    @Test
    public void testGetAllUsers()
    {
        long count = repository.count();
        users = service.getAllUsers();
        Assert.assertTrue(users.size() == count);
    }

    @Test
    public void testGetUser()
    {
        User user = repository.findOne(id);
        Assert.assertEquals("Username: Found\nPassword: Found", service.getUser(user.getEmailAddress(), user.getPassword()));
    }

    @Test
    public void testNewUser()
    {
        //Must change the email address field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.newUser("Jon", "123", "Help", "Me"));
    }

    @Test
    public void testForgottenPassword()
    {
        Long testID;
        testID = service.ForgottenPassword("jonathanerasmus1992@gmail.com");
        Assert.assertNotNull(testID);
    }

    @Test
    public void testRecoveryQuestion()
    {
        Assert.assertEquals("1 + 1", service.RecoveryQuestion(id));
    }

    @Test
    public void testRecoveryAnswer()
    {
        Assert.assertTrue(service.RecoveryAnswer("3", id));
    }

    @Test
    public void testChangePassword()
    {
        Assert.assertTrue(service.ChangePassword("256", id));
    }
}


