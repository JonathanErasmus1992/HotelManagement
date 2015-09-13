package hotelmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class EmployeeContact implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String cell_number;
    private String home_number;
    private String email_address;
    private String next_of_kin_contact;

    private EmployeeContact()
    {

    }

    public EmployeeContact( Builder builder )
    {
        ID = builder.ID;
        cell_number = builder.cell_number;
        home_number = builder.home_number;
        email_address = builder.email_address;
        next_of_kin_contact = builder.next_of_kin_contact;
    }

    public Long getID()
    {
        return this.ID;
    }
    public String getCellNumber()
    {
        return cell_number;
    }
    public String getHomeNumber()
    {
        return home_number;
    }
    public String getEmailAddress()
    {
        return email_address;
    }
    public String getNextOfKinContact()
    {
        return next_of_kin_contact;
    }

    public static class Builder
    {
        private Long ID;
        private String cell_number;
        private String home_number;
        private String email_address;
        private String next_of_kin_contact;

        public Builder( String cell_number )
        {
            this.cell_number = cell_number;
        }
        public Builder ID(Long ID)
        {
            this.ID=ID;
            return this;
        }
        public Builder home_number( String value )
        {
            this.home_number = value;
            return this;
        }
        public Builder email_address( String value )
        {
            this.email_address = value;
            return this;
        }
        public Builder next_of_kin_contact( String value )
        {
            this.next_of_kin_contact = value;
            return this;
        }
        public Builder copy( EmployeeContact value )
        {
            this.ID = value.getID();
            this.cell_number = value.getCellNumber();
            this.home_number = value.getHomeNumber();
            this.email_address = value.getEmailAddress();
            this.next_of_kin_contact = value.getNextOfKinContact();

            return this;
        }

        public EmployeeContact build()
        {
            return new EmployeeContact( this );
        }
    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "ID=" + ID +
                ", cell_number='" + cell_number + '\'' +
                ", home_number='" + home_number + '\'' +
                ", email_address='" + email_address + '\'' +
                ", next_of_kin_contact='" + next_of_kin_contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeContact that = (EmployeeContact) o;

        if (!ID.equals(that.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}