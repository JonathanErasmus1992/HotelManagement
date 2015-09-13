package hotelmanagement.services.Impl;

import hotelmanagement.conf.ServicesAndAddOnsFactory;
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.repository.ServicesAndAddOnsRepo;
import hotelmanagement.services.ServicesAndAddOnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
@Service
public class ServicesAndAddOnsServiceImpl implements ServicesAndAddOnsService {
    @Autowired
    ServicesAndAddOnsRepo repositoryServicesAndAddOns;

    @Override
    public List<ServicesAndAddOns> getAllServicesAndAddOns() {
        List<ServicesAndAddOns> allServicesAndAddOns = new ArrayList<ServicesAndAddOns>();

        Iterable<ServicesAndAddOns> servicesAndAddOnses = repositoryServicesAndAddOns.findAll();
        for (ServicesAndAddOns servicesAndAddOn : servicesAndAddOnses) {
            allServicesAndAddOns.add(servicesAndAddOn);
        }
        return allServicesAndAddOns;
    }

    @Override
    public boolean createServicesAndAddOns(int serv_extras_id, String extraName, double extraPrice) {
        int count = 0;
        boolean blnCreateServicesAndAddOn ;
        Iterable<ServicesAndAddOns> servicesAndAddOnses = repositoryServicesAndAddOns.findAll();
        for (ServicesAndAddOns servicesAndAddOn : servicesAndAddOnses) {
            if (servicesAndAddOn.getServExtraID() == serv_extras_id)
            {
                count = count + 1;
            }
        }
        if (count == 0)
        {
            ServicesAndAddOns servicesAndAddOns = ServicesAndAddOnsFactory.createServicesAndAddOns(0, "Mini Bar", 200);
            repositoryServicesAndAddOns.save(servicesAndAddOns);
            blnCreateServicesAndAddOn = true;
        }
        else
        {
            //False is generated if the room exists already
            blnCreateServicesAndAddOn = false;
        }
        return blnCreateServicesAndAddOn;
    }

    @Override
    public boolean updateServicesAndAddOns(int serv_extras_id, String extraName, double extraPrice) {
        boolean blnServicesAndAddOnsUpdate = false;
        Long ID = 0L;

        Iterable<ServicesAndAddOns> servicesAndAddOnses = repositoryServicesAndAddOns.findAll();
        for (ServicesAndAddOns servicesAndAddOn : servicesAndAddOnses) {
            if (servicesAndAddOn.getServExtraID() == serv_extras_id)
            {
                blnServicesAndAddOnsUpdate = true;
                ID = servicesAndAddOn.getID();
            }
        }

        if (blnServicesAndAddOnsUpdate == true)
        {
            ServicesAndAddOns servicesAndAddOns =   repositoryServicesAndAddOns.findOne(ID);
            ServicesAndAddOns newServicesAndAddOns = new ServicesAndAddOns.Builder(servicesAndAddOns.getServExtraID())
                    .ID(ID)
                    .extra_name(extraName)
                    .price_added(extraPrice)
                    .build();
            repositoryServicesAndAddOns.save(newServicesAndAddOns);
        }

        return blnServicesAndAddOnsUpdate;
    }

    @Override
    public boolean deleteServicesAndAddOns(int serv_extras_id) {
        boolean blnServicesAndAddOnsDelete = false;
        Long ID = 0L;

        Iterable<ServicesAndAddOns> servicesAndAddOnses = repositoryServicesAndAddOns.findAll();
        for (ServicesAndAddOns servicesAndAddOn : servicesAndAddOnses) {
            if (servicesAndAddOn.getServExtraID() == serv_extras_id)
            {
                blnServicesAndAddOnsDelete = true;
                ID = servicesAndAddOn.getID();
            }
        }

        if (blnServicesAndAddOnsDelete == true)
        {
            repositoryServicesAndAddOns.delete(ID);
        }

        return false;
    }
}
