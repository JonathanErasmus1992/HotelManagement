package hotelmanagement.domain;


import hotelmanagement.conf.JobFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestJobFactory {
    private Job job;
    private Job newJob;
    @Before
    public void setUp()
    {
        job = JobFactory.createJob("011", "Hotel", "Cleaning", "Clean", 2500.00);
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals("011", job.getJobCode());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newJob = new Job
                .Builder(job.getJobCode())
                .copy(job)
                .job_description("Room Clean")
                .build();
        Assert.assertEquals("011", newJob.getJobCode());
        Assert.assertEquals("Room Clean", newJob.getJobDescription());
    }
    @After
    public void tearDown()
    {

    }
}
