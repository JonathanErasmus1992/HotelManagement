package hotelmanagement.repository;

import hotelmanagement.domain.CustomerBooking;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface CustomerBookingRepo extends CrudRepository<CustomerBooking, Long> {
}
