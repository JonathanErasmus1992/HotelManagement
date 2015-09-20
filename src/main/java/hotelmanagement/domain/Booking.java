package hotelmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class Booking implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String reference_number;
    private String rooms;
    private String services_and_addons;
    private Date hireDate;

    private Booking(){}

    public Booking( Builder builder )
    {
        ID = builder.ID;
        reference_number = builder.reference_number;
        rooms = builder.rooms;
        services_and_addons = builder.services_and_addons;
        hireDate = builder.hireDate;
    }
    public Long getID()
    {
        return this.ID;
    }
    public String getReferenceNumber()
    {
        return reference_number;
    }
    public String getRooms()
    {
        return rooms;
    }
    public String getServicesAndAddOns()
    {
        return services_and_addons;
    }
    public Date getDate()
    {
        return hireDate;
    }

    public static class Builder
    {
        private Long ID;
        private String reference_number;
        private String rooms;
        private String services_and_addons;
        private Date hireDate;

        public Builder( String reference_number )
        {
            this.reference_number = reference_number;
        }

        public Builder ID(Long value)
        {
            this.ID=value;
            return this;
        }

        public Builder rooms( String value )
        {
            this.rooms = value;
            return this;
        }
        public Builder services_and_addons( String value )
        {
            this.services_and_addons = value;
            return this;
        }
        public Builder hireDate( Date value )
        {
            this.hireDate = value;
            return this;
        }
        public Builder copy( Booking value )
        {
            this.ID = value.getID();
            this.reference_number = value.getReferenceNumber();
            this.rooms = value.getRooms();
            this.services_and_addons = value.getServicesAndAddOns();
            this.hireDate = value.getDate();

            return this;
        }

        public Booking build()
        {
            return new Booking( this );
        }
    }

    @Override
    public String toString() {
        return "Booking{" +
                "ID=" + ID +
                ", reference_number='" + reference_number + '\'' +
                ", rooms=" + rooms +
                ", services_and_addons=" + services_and_addons +
                ", dates=" + hireDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (!ID.equals(booking.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}
