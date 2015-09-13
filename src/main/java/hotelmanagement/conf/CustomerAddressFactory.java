package hotelmanagement.conf;

import hotelmanagement.domain.CustomerAddress;

/**
 * Created by student on 2015/05/05.
 */
public class CustomerAddressFactory {
    public static CustomerAddress createCustomerAddress( String physical_address,
                                                         String postal_address,
                                                         String postal_code)
    {
        CustomerAddress customer_address = new CustomerAddress
                .Builder(physical_address)
                .postal_address(postal_address)
                .postal_code(postal_code)
                .build();
        return customer_address;
    }

}
