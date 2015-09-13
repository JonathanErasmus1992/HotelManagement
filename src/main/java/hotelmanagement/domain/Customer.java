package hotelmanagement.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class Customer implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String ID_number;
    private String customer_firstnames;
    private String customer_lastname;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<CustomerAddress> customer_address;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<CustomerContact> customer_contact;

    private Customer(){}

    public Customer( Builder builder )
    {
        ID = builder.ID;
        ID_number = builder.ID_number;
        customer_firstnames = builder.customer_firstnames;
        customer_lastname = builder.customer_lastname;
        customer_address = builder.customer_address;
        customer_contact = builder.customer_contact;
    }

    public Long getID()
    {
        return ID;
    }
    public String getIDNumber()
    {
        return ID_number;
    }
    public String getFirstnames()
    {
        return customer_firstnames;
    }
    public String getLastname()
    {
        return customer_lastname;
    }
    public List<CustomerAddress> getCustomerAddress()
    {
        return customer_address;
    }
    public List<CustomerContact> getCustomerContact()
    {
        return customer_contact;
    }

    public static class Builder
    {
        private Long ID;
        private String ID_number;
        private String customer_firstnames;
        private String customer_lastname;
        private List<CustomerAddress> customer_address;
        private List<CustomerContact> customer_contact;

        public Builder( String ID_number )
        {
            this.ID_number = ID_number;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder customer_firstnames( String value )
        {
            this.customer_firstnames = value;
            return this;
        }
        public Builder customer_lastname( String value )
        {
            this.customer_lastname = value;
            return this;
        }
        public Builder customer_address( List<CustomerAddress> value )
        {
            this.customer_address = value;
            return this;
        }
        public Builder customer_contact( List<CustomerContact> value )
        {
            this.customer_contact = value;
            return this;
        }
        public Builder copy( Customer value )
        {
            this.ID_number = value.getIDNumber();
            this.ID = value.getID();
            this.customer_firstnames = value.getFirstnames();
            this.customer_lastname = value.getLastname();
            this.customer_address = value.getCustomerAddress();
            this.customer_contact = value.getCustomerContact();

            return this;
        }

        public Customer build()
        {
            return new Customer( this );
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return !(ID != null ? !ID.equals(customer.ID) : customer.ID != null);
    }
    @Override
    public int hashCode()
    {
        return ID != null ? ID.hashCode() : 0;
    }
}
