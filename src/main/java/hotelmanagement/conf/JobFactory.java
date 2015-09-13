package hotelmanagement.conf;

import hotelmanagement.domain.Job;

/**
 * Created by student on 2015/05/05.
 */
public class JobFactory
{
    public static Job createJob( String j_code,
                                 String j_type,
                                 String j_title,
                                 String j_descr,
                                 double basic_sal )
    {
        Job job = new Job
                .Builder( j_code )
                .job_type( j_type )
                .job_title( j_title )
                .job_description( j_descr )
                .basic_salary( basic_sal )
                .build();

        return job;
    }
}
