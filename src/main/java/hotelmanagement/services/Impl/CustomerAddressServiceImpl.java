package hotelmanagement.services.Impl;

import hotelmanagement.conf.CustomerAddressFactory;
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.repository.CustomerAddressRepo;
import hotelmanagement.services.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    @Autowired
    CustomerAddressRepo repositoryCustomerAddress;

    @Override
    public List<CustomerAddress> getAllCustomerAddresses() {
        List<CustomerAddress> allCustomerAddress = new ArrayList<CustomerAddress>();

        Iterable<CustomerAddress> customerAddresses = repositoryCustomerAddress.findAll();
        for (CustomerAddress customerAddress : customerAddresses) {
            allCustomerAddress.add(customerAddress);
        }
        return allCustomerAddress;
    }

    @Override
    public boolean createCustomerAddress(String physicalAddress, String postalAddress, String postalCode) {
        int count = 0;
        boolean blnCustomerAddressCreated;
        Iterable<CustomerAddress> customerAddresses = repositoryCustomerAddress.findAll();
        for (CustomerAddress customerAddress : customerAddresses) {
            if (customerAddress.getPhysicalAddress().equalsIgnoreCase(physicalAddress))
            {
                count = count + 1;
            }
        }

        if (count == 0)
        {
            CustomerAddress customerAddress = CustomerAddressFactory.createCustomerAddress("51 Reddy Avenue Grassy Park", "Same As Physical", "7941");
            repositoryCustomerAddress.save(customerAddress);
            blnCustomerAddressCreated = true;
        }
        else
        {
            blnCustomerAddressCreated = false;
        }
        return blnCustomerAddressCreated;
    }

    @Override
    public boolean updateCustomerAddress(String physicalAddress, String postalAddress, String postalCode) {
        boolean blnUpdateCustomerAddress = false;
        Long ID = 0L;

        Iterable<CustomerAddress> customerAddresses = repositoryCustomerAddress.findAll();
        for (CustomerAddress customerAddress : customerAddresses) {
            if (customerAddress.getPhysicalAddress().equalsIgnoreCase(physicalAddress))
            {
                blnUpdateCustomerAddress = true;
                ID = customerAddress.getID();
            }
        }

        if (blnUpdateCustomerAddress == true)
        {
            CustomerAddress customerAddress = repositoryCustomerAddress.findOne(ID);
            CustomerAddress newCustomerAddress = new CustomerAddress.Builder(customerAddress.getPhysicalAddress())
                    .ID(ID)
                    .postal_address(postalAddress)
                    .postal_code(postalCode)
                    .build();
            repositoryCustomerAddress.save(newCustomerAddress);
        }

        return blnUpdateCustomerAddress;
    }
}
