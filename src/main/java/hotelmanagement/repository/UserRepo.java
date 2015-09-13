package hotelmanagement.repository;

import hotelmanagement.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/09.
 */
public interface UserRepo extends CrudRepository<User, Long> {
}
