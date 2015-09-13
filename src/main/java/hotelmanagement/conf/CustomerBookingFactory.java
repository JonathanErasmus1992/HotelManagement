package hotelmanagement.conf;

import hotelmanagement.domain.CustomerBooking;

/**
 * Created by student on 2015/09/13.
 */
public class CustomerBookingFactory {

    public static CustomerBooking createCustomerBooking(String referenceNumber,
                                                        String idNumber,
                                                        String firstNames,
                                                        String lastName)
    {
        CustomerBooking customerBooking = new CustomerBooking
                .Builder(referenceNumber)
                .idNumber(idNumber)
                .firstNames(firstNames)
                .lastName(lastName)
                .build();
        return customerBooking;
    }
}
