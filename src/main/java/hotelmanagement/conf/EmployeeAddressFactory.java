package hotelmanagement.conf;

import hotelmanagement.domain.EmployeeAddress;

/**
 * Created by student on 2015/05/05.
 */
public class EmployeeAddressFactory {
    public static EmployeeAddress createCustomerAddress( String physical_address,
                                                         String postal_address,
                                                         String postal_code)
    {
        EmployeeAddress employee_address = new EmployeeAddress
                .Builder(physical_address)
                .postal_address(postal_address)
                .postal_code(postal_code)
                .build();
        return employee_address;
    }

}
