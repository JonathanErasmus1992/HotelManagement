package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */

import hotelmanagement.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
