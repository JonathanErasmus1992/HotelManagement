package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepo  extends CrudRepository<Booking, Long>{
}
