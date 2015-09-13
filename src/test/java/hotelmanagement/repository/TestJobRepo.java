package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.Job;
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
public class TestJobRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    JobRepo repository;
    @Test
    public void testCreate() throws Exception {
        Job job = new Job.Builder("J1234")
                .job_title("Clerk")
                .job_description("Front Desk Admin")
                .job_type("HR")
                .basic_salary(2000.00)
                .build();
        repository.save(job);
        id = job.getID();
        Assert.assertNotNull(job);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        Job job = repository.findOne(id);
        Assert.assertEquals("J1234", job.getJobCode());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        Job job = repository.findOne(id);
        Job newJob = new Job.Builder(job.getJobCode())
                .ID(id)
                .job_title("Clerk")
                .job_description("Front Desk Admin")
                .job_type("HR")
                .basic_salary(2300.00)
                .build();
        repository.save(newJob);

        Job updatedJob = repository.findOne(id);
        Assert.assertEquals(2300.00, updatedJob.getBasicSalary(), 2);
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        Job job = repository.findOne(id);
        repository.delete(job);
        Job newJob = repository.findOne(id);
        Assert.assertNull(newJob);
    }
}
