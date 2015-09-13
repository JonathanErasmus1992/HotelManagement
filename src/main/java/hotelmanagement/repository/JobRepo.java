package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job, Long> {
}
