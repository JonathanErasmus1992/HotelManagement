package hotelmanagement.conf;

import hotelmanagement.domain.EmployeeContact;

/**
 * Created by student on 2015/05/05.
 */
public class EmployeeContactFactory {
    public static EmployeeContact createCustomerContact(String cell_number,
                                                        String home_number,
                                                        String email_address,
                                                        String next_of_kind_contact)
    {
        EmployeeContact employee_contact = new EmployeeContact
                .Builder(cell_number)
                .home_number(home_number)
                .email_address(email_address)
                .next_of_kin_contact(next_of_kind_contact)
                .build();
        return employee_contact;
    }
}
