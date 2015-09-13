package hotelmanagement.services;

import hotelmanagement.domain.CustomerAddress;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface CustomerAddressService {
    public List<CustomerAddress> getAllCustomerAddresses();
    public boolean createCustomerAddress(String physicalAddress, String postalAddress, String postalCode);
    public boolean updateCustomerAddress(String physicalAddress, String postalAddress, String postalCode);
}
