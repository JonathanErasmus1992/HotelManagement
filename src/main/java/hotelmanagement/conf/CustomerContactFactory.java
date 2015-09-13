package hotelmanagement.conf;

import hotelmanagement.domain.CustomerContact;

/**
 * Created by student on 2015/05/05.
 */
public class CustomerContactFactory {
    public static CustomerContact createCustomerContact(String cell_number,
                                                        String home_number,
                                                        String email_address,
                                                        String next_of_kind_contact)
    {
        CustomerContact customer_contact = new CustomerContact
                .Builder(cell_number)
                .home_number(home_number)
                .email_address(email_address)
                .next_of_kin_contact(next_of_kind_contact)
                .build();
        return customer_contact;
    }
}
