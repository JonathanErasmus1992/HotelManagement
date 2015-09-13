package hotelmanagement.conf;

import hotelmanagement.domain.Customer;
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.domain.CustomerContact;

import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
public class CustomerFactory
{

    public static Customer createCustomer( String IDnumber,
                                           String firstnames,
                                           String lastname,
                                           List<CustomerAddress> cust_address,
                                           List<CustomerContact> cust_contact )
    {
        Customer customer = new Customer
                .Builder(IDnumber)
                .customer_firstnames( firstnames )
                .customer_lastname( lastname )
                .customer_address( cust_address )
                .customer_contact( cust_contact )
                .build();
        return customer;
    }
}
