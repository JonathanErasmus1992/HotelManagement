package hotelmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class CustomerAddress implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String physical_address;
    private String postal_address;
    private String postal_code;

    private CustomerAddress()
    {

    }

    public CustomerAddress( Builder builder )
    {
        ID = builder.ID;
        physical_address = builder.physical_address;
        postal_address = builder.postal_address;
        postal_code = builder.postal_code;
    }

    public Long getID(){return ID;}
    public String getPhysicalAddress()
    {
        return physical_address;
    }
    public String getPostalAddress()
    {
        return postal_address;
    }
    public String getPostalCode()
    {
        return postal_code;
    }

    public static class Builder
    {
        private Long ID;
        private String physical_address;
        private String postal_address;
        private String postal_code;

        public Builder( String physical_address )
        {
            this.physical_address = physical_address;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder postal_address( String value )
        {
            this.postal_address = value;
            return this;
        }
        public Builder postal_code( String value )
        {
            this.postal_code = value;
            return this;
        }
        public Builder copy( CustomerAddress value )
        {
            this.ID = value.getID();
            this.physical_address = value.getPhysicalAddress();
            this.postal_address = value.getPostalAddress();
            this.postal_code = value.getPostalCode();

            return this;
        }

        public CustomerAddress build()
        {
            return new CustomerAddress( this );
        }
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "ID=" + ID +
                ", physical_address='" + physical_address + '\'' +
                ", postal_address='" + postal_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress that = (CustomerAddress) o;

        if (!ID.equals(that.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}
