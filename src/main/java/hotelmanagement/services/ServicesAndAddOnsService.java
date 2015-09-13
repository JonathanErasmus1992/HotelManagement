package hotelmanagement.services;

import hotelmanagement.domain.ServicesAndAddOns;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface ServicesAndAddOnsService {
    public List<ServicesAndAddOns> getAllServicesAndAddOns();
    public boolean createServicesAndAddOns(int serv_extras_id, String extraName, double extraPrice);
    public boolean updateServicesAndAddOns(int serv_extras_id, String extraName, double extraPrice);
    public boolean deleteServicesAndAddOns(int serv_extras_id);
}
