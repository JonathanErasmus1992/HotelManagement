package hotelmanagement.services;

import hotelmanagement.domain.CustomerContact;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface CustomerContactService {
    public List<CustomerContact> getAllCustomerContacts();
    public boolean createCustomerContact(String cellNumber, String homeNumber, String emailAddress, String NOKN);
    public boolean updateCustomerContact(String cellNumber, String homeNumber, String emailAddress, String NOKN);
}
