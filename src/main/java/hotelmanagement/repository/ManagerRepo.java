package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepo extends CrudRepository<Manager, Long> {
}
