package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.EmployeeDemographics;
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
public class TestEmployeeDemographicsRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    EmployeeDemographicsRepo repository;
    @Test
    public void testCreate() throws Exception {
        EmployeeDemographics employeeDemographics = new EmployeeDemographics.Builder("Coloured")
                .gender("male")
                .home_language("English")
                .build();
        repository.save(employeeDemographics);
        id = employeeDemographics.getID();
        Assert.assertNotNull(employeeDemographics);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        EmployeeDemographics employeeDemographics = repository.findOne(id);
        Assert.assertEquals("Coloured", employeeDemographics.getRace());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        EmployeeDemographics employeeDemographics = repository.findOne(id);
        EmployeeDemographics newEmployeeDemographics = new EmployeeDemographics.Builder(employeeDemographics.getRace())
                .ID(id)
                .gender("male")
                .home_language("English 3")
                .build();
        repository.save(newEmployeeDemographics);

        EmployeeDemographics updatedEmployeeDemographics = repository.findOne(id);
        Assert.assertEquals("English 3", updatedEmployeeDemographics.getHomeLanguage());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        EmployeeDemographics employeeDemographics = repository.findOne(id);
        repository.delete(employeeDemographics);
        EmployeeDemographics newEmployeeDemographics = repository.findOne(id);
        Assert.assertNull(newEmployeeDemographics);
    }
}
