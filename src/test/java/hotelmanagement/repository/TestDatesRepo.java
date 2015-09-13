package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.Dates;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by student on 2015/09/09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestDatesRepo extends AbstractTestNGSpringContextTests {
    private Long id;
    private Date d1;
    @Autowired
    DatesRepo repository;
    @Test
    public void testCreate() throws Exception {

    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {

    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {

    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {

    }
}
