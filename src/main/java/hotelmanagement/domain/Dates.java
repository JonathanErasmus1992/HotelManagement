package hotelmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class Dates implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Date booking_made_date;
    private Date booking_arrival_date;
    private Date booking_departure_date;

    private Dates(){}

    public Dates( Builder builder )
    {
        ID = builder.ID;
        booking_made_date = builder.booking_made_date;
        booking_arrival_date = builder.booking_arrival_date;
        booking_departure_date = builder.booking_departure_date;
    }
    public Long getID()
    {
        return ID;
    }
    public Date getBookingMadeDate()
    {
        return booking_made_date;
    }
    public Date getBookingArrivalDate()
    {
        return booking_arrival_date;
    }
    public Date getBookingDepartureDate()
    {
        return booking_departure_date;
    }

    public static class Builder
    {
        private Long ID;
        private Date booking_made_date;
        private Date booking_arrival_date;
        private Date booking_departure_date;

        public Builder(Date booking_made_date)
        {
            this.booking_made_date = booking_made_date;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder booking_arrival_date( Date value )
        {
            this.booking_arrival_date = value;
            return this;
        }
        public Builder booking_departure_date( Date value )
        {
            this.booking_departure_date = value;
            return this;
        }
        public Builder copy( Dates value )
        {
            this.ID = value.getID();
            this.booking_made_date = value.getBookingMadeDate();
            this.booking_arrival_date = value.getBookingArrivalDate();
            this.booking_departure_date = value.getBookingDepartureDate();

            return this;
        }

        public Dates build()
        {
            return new Dates( this );
        }
    }

    @Override
    public String toString() {
        return "Dates{" +
                "ID=" + ID +
                ", booking_made_date=" + booking_made_date +
                ", booking_arrival_date=" + booking_arrival_date +
                ", booking_departure_date=" + booking_departure_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dates)) return false;

        Dates dates = (Dates) o;

        return !(ID != null ? !ID.equals(dates.ID) : dates.ID != null);

    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }
}
