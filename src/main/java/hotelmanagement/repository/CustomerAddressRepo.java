package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.CustomerAddress;
import org.springframework.data.repository.CrudRepository;

public interface CustomerAddressRepo extends CrudRepository<CustomerAddress, Long>{
}
