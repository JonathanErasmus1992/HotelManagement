package hotelmanagement.services.Impl;

import hotelmanagement.conf.CustomerContactFactory;
import hotelmanagement.domain.CustomerContact;
import hotelmanagement.repository.CustomerContactRepo;
import hotelmanagement.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    @Autowired
    private CustomerContactRepo repositoryCustomerContact;

    @Override
    public List<CustomerContact> getAllCustomerContacts() {
        List<CustomerContact> allCustomerContactList = new ArrayList<CustomerContact>();

        Iterable<CustomerContact> customerContacts = repositoryCustomerContact.findAll();
        for (CustomerContact customerContact : customerContacts) {
            allCustomerContactList.add(customerContact);
        }

        return allCustomerContactList;
    }

    @Override
    public boolean createCustomerContact(String cellNumber, String homeNumber, String emailAddress, String NOKN) {
        int count = 0;
        boolean blnCreateCustomerContact;

        Iterable<CustomerContact> customerContacts = repositoryCustomerContact.findAll();
        for (CustomerContact customerContact : customerContacts) {
            if (customerContact.getCellNumber().equalsIgnoreCase(cellNumber))
            {
                count = count + 1;
            }
        }

        if(count == 0)
        {
            CustomerContact customerContact = CustomerContactFactory.createCustomerContact(cellNumber, homeNumber, emailAddress, NOKN);
            repositoryCustomerContact.save(customerContact);
            blnCreateCustomerContact = true;
        }
        else
        {
            blnCreateCustomerContact = false;
        }

        return blnCreateCustomerContact;
    }

    @Override
    public boolean updateCustomerContact(String cellNumber, String homeNumber, String emailAddress, String NOKN) {
        boolean blnCustomerContactUpdate = false;
        Long ID = 0L;

        Iterable<CustomerContact> customerContacts = repositoryCustomerContact.findAll();
        for (CustomerContact customerContact : customerContacts) {
            if (customerContact.getCellNumber().equalsIgnoreCase(cellNumber))
            {
                blnCustomerContactUpdate = true;
                ID = customerContact.getID();
            }
        }

        if (blnCustomerContactUpdate == true)
        {
            CustomerContact customerContact = repositoryCustomerContact.findOne(ID);
            CustomerContact newCustomerContact = new CustomerContact.Builder(customerContact.getCellNumber())
                    .ID(ID)
                    .home_number(homeNumber)
                    .email_address(emailAddress)
                    .next_of_kin_contact(NOKN)
                    .build();
            repositoryCustomerContact.save(newCustomerContact);
        }
        else
        {
            blnCustomerContactUpdate = false;
        }

        return blnCustomerContactUpdate;
    }
}
