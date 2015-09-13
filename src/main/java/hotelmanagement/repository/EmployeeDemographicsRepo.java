package hotelmanagement.repository;

/**
 * Created by student on 2015/09/09.
 */
import hotelmanagement.domain.EmployeeDemographics;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDemographicsRepo extends CrudRepository<EmployeeDemographics, Long>{
}
