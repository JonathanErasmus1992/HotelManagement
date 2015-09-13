package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.EmployeeContact;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeContactRepo extends CrudRepository<EmployeeContact, Long> {
}
