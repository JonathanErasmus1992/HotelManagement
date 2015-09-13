package hotelmanagement.conf;

import hotelmanagement.domain.ServicesAndAddOns;

/**
 * Created by student on 2015/05/05.
 */
public class ServicesAndAddOnsFactory
{
    public static ServicesAndAddOns createServicesAndAddOns( int serv_ext_id,
                                                             String ext_name,
                                                             double pr_added )
    {
        ServicesAndAddOns services_and_addons = new ServicesAndAddOns
                .Builder( serv_ext_id )
                .extra_name( ext_name )
                .price_added( pr_added )
                .build();

        return services_and_addons;
    }
}
