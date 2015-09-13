package hotelmanagement.services;

import hotelmanagement.domain.Customer;
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.domain.CustomerContact;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public interface CustomerService {
    public List<Customer> getAllCustomers();
    public boolean createCustomer(String idNumber, String firstNames, String lastName, String physicalAddress,
                                  String postalAddress, String postalCode, String cellNumber, String homeNumber,
                                  String emailAddress, String NOKN);
    public boolean updateCustomer(String idNumber, String firstNames, String lastName, String physicalAddress,
                                  String postalAddress, String postalCode, String cellNumber, String homeNumber,
                                  String emailAddress, String NOKN);
}
