package hotelmanagement.services.Impl;

import hotelmanagement.domain.Customer;
import hotelmanagement.domain.CustomerAddress;
import hotelmanagement.domain.CustomerContact;
import hotelmanagement.repository.CustomerAddressRepo;
import hotelmanagement.repository.CustomerContactRepo;
import hotelmanagement.repository.CustomerRepo;

import hotelmanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repositoryCustomer;

    @Autowired
    private CustomerAddressRepo repositoryCustomerAddress;

    @Autowired
    private CustomerContactRepo repositoryCustomerContact;

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomer = new ArrayList<Customer>();

        Iterable<Customer> customers = repositoryCustomer.findAll();
        for (Customer customer : customers) {
            allCustomer.add(customer);
        }
        return allCustomer;
    }

    @Override
    public boolean createCustomer(String idNumber, String firstNames, String lastName, String physicalAddress,
                                  String postalAddress, String postalCode, String cellNumber, String homeNumber,
                                  String emailAddress, String NOKN) {
        int count = 0;
        boolean blnCreateCustomer;

        List<CustomerContact> tempContacts = new ArrayList<CustomerContact>();
        List<CustomerAddress> tempAddresses = new ArrayList<CustomerAddress>();

        Iterable<Customer> customers = repositoryCustomer.findAll();
        for (Customer customer : customers) {
            if (customer.getIDNumber().equalsIgnoreCase(idNumber))
            {
                count = count + 1;
                tempContacts = customer.getCustomerContact();
                tempAddresses = customer.getCustomerAddress();
            }
        }
        if (count == 0)
        {
            CustomerAddress newCustomerAddresss = new CustomerAddress.Builder(physicalAddress)
                    .postal_address(postalAddress)
                    .postal_code(postalCode)
                    .build();
            repositoryCustomerAddress.save(newCustomerAddresss);
            tempAddresses.add(newCustomerAddresss);

            CustomerContact newCustomerContact = new CustomerContact.Builder(cellNumber)
                    .home_number(homeNumber)
                    .email_address(emailAddress)
                    .next_of_kin_contact(NOKN)
                    .build();
            repositoryCustomerContact.save(newCustomerContact);
            tempContacts.add(newCustomerContact);

            Customer newCustomer = new Customer.Builder(idNumber)
                    .customer_firstnames(firstNames)
                    .customer_lastname(lastName)
                    .customer_contact(tempContacts)
                    .customer_address(tempAddresses)
                    .build();
            repositoryCustomer.save(newCustomer);

            blnCreateCustomer = true;
        }
        else
        {
            blnCreateCustomer =false;
        }
        return blnCreateCustomer;
    }

    @Override
    public boolean updateCustomer(String idNumber, String firstNames, String lastName, String physicalAddress,
                                  String postalAddress, String postalCode, String cellNumber, String homeNumber,
                                  String emailAddress, String NOKN) {

        boolean blnUpdateCustomer= false;
        Long customerID = 0L;
        Long contactID = 0L;
        Long addressID = 0L;

        List<CustomerContact> tempContacts = new ArrayList<CustomerContact>();
        List<CustomerAddress> tempAddresses = new ArrayList<CustomerAddress>();

        Iterable<Customer> customers = repositoryCustomer.findAll();
        for (Customer customer : customers) {
            if (customer.getIDNumber().equalsIgnoreCase(idNumber))
            {
                customerID = customer.getID();

                /*tempContacts = customer.getCustomerContact();
                int i1 = 0;
                i1 = tempContacts.lastIndexOf(tempContacts);
                CustomerContact custContact = tempContacts.get(i1);
                contactID = custContact.getID();

                System.out.println(tempContacts.size());
                System.out.println(tempContacts.get(0));

                tempAddresses = customer.getCustomerAddress();
                int i2 = 0;
                i2 = tempAddresses.lastIndexOf(tempAddresses);
                CustomerAddress custAddress = tempAddresses.get(i2);
                addressID = custAddress.getID();*/

                blnUpdateCustomer = true;
            }
        }

        if (blnUpdateCustomer == true)
        {
           Customer customer = repositoryCustomer.findOne(customerID);

           /*CustomerAddress customerAddress = repositoryCustomerAddress.findOne(addressID);
           CustomerAddress newCustomerAddress = new CustomerAddress.Builder(customerAddress.getPhysicalAddress())
                .ID(addressID)
                .postal_address(postalAddress)
                .postal_code(postalCode)
                .build();
            repositoryCustomerAddress.save(newCustomerAddress);

            CustomerContact customerContact = repositoryCustomerContact.findOne(contactID);
            CustomerContact newCustomerContact = new CustomerContact.Builder(customerContact.getCellNumber())
                    .ID(contactID)
                    .home_number(homeNumber)
                    .email_address(emailAddress)
                    .next_of_kin_contact(NOKN)
                    .build();
            repositoryCustomerContact.save(newCustomerContact);*/

            Customer newCustomer = new Customer.Builder(customer.getIDNumber())
                    .ID(customerID)
                    .customer_firstnames("Jon")
                    .customer_lastname("David")
                    //.customer_address(newCustomerAddress)
                    //.customer_contact(newCustomerContact)
                    .build();
            repositoryCustomer.save(newCustomer);
        }

        return blnUpdateCustomer;
    }
}
