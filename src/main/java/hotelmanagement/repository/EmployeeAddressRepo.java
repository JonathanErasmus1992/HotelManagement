package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.EmployeeAddress;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeAddressRepo extends CrudRepository<EmployeeAddress, Long>{
}
