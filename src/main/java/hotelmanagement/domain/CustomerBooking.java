package hotelmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class CustomerBooking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idNumber;
    private String firstNames;
    private String lastName;
    private String referenceNumber;

    private CustomerBooking(){}

    public CustomerBooking(Builder builder)
    {
        id = builder.id;
        idNumber = builder.idNumber;
        firstNames = builder.firstNames;
        lastName = builder.lastName;
        referenceNumber = builder.referenceNumber;
    }

    public Long getId()
    {
        return this.id;
    }
    public String getIdNumber()
    {
        return this.idNumber;
    }
    public String getFirstNames()
    {
        return this.firstNames;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getReferenceNumber()
    {
        return this.referenceNumber;
    }

    public static class Builder
    {
        private Long id;
        private String idNumber;
        private String firstNames;
        private String lastName;
        private String referenceNumber;

        public Builder(String referenceNumber)
        {
            this.referenceNumber = referenceNumber;
        }
        public Builder id(Long value) {
            this.id=value;
            return this;
        }
        public Builder idNumber(String value) {
            this.idNumber = value;
            return this;
        }
        public Builder firstNames(String value) {
            this.firstNames = value;
            return this;
        }
        public Builder lastName(String value) {
            this.lastName = value;
            return this;
        }
        public Builder copy(CustomerBooking value) {
            this.id = value.getId();
            this.idNumber = value.getIdNumber();
            this.firstNames = value.getFirstNames();
            this.lastName = value.getLastName();
            this.referenceNumber = value.getReferenceNumber();

            return this;
        }

        public CustomerBooking build(){
            return new CustomerBooking(this);
        }
    }

    @Override
    public String toString() {
        return "CustomerBooking{" +
                "id=" + id +
                ", idNumber='" + idNumber + '\'' +
                ", firstNames='" + firstNames + '\'' +
                ", lastName='" + lastName + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBooking that = (CustomerBooking) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
