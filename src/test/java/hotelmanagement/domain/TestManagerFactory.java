package hotelmanagement.domain;

import hotelmanagement.conf.ManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestManagerFactory {
    private Manager man;
    private Manager newMan;
    @Before
    public void setUp()
    {
        man = ManagerFactory.createManager("222", "Clean");
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("222", man.getManagerID());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newMan = new Manager
                .Builder(man.getManagerID())
                .copy(man)
                .manager_title("Main")
                .build();
        Assert.assertEquals("222", newMan.getManagerID());
        Assert.assertEquals("Main", newMan.getManagerTitle());
    }
    @After
    public void tearDown()
    {

    }
}
