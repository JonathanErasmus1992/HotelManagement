package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepo extends CrudRepository<CustomerContact, Long>{
}
