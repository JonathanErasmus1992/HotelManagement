package hotelmanagement.domain;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private int room_number;
    private String room_type;
    private String room_view;
    private double room_price;

    private Room() {}
    public Room(Builder builder) {
        ID = builder.ID;
        room_number = builder.room_number;
        room_type = builder.room_type;
        room_view = builder.room_view;
        room_price = builder.room_price;
    }

    public Long getID()
    {
        return ID;
    }

    public int getRoomNumber() {
        return room_number;
    }

    public String getRoomType() {
        return room_type;
    }

    public String getRoomView() {
        return room_view;
    }

    public double getRoomPrice() {
        return room_price;
    }

    public static class Builder
    {
        private Long ID;
        private int room_number;
        private String room_type;
        private String room_view;
        private double room_price;

        public Builder( int room_number )
        {
            this.room_number = room_number;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder room_type( String value )
        {
            this.room_type = value;
            return this;
        }
        public Builder room_view( String value )
        {
            this.room_view = value;
            return this;
        }
        public Builder room_price( double value )
        {
            this.room_price = value;
            return this;
        }
        public Builder copy( Room value )
        {
            this.ID = value.getID();
            this.room_number = value.getRoomNumber();
            this.room_type = value.getRoomType();
            this.room_view = value.getRoomView();
            this.room_price = value.getRoomPrice();

            return this;
        }

        public Room build()
        {
            return new Room( this );
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "ID=" + ID +
                ", room_number=" + room_number +
                ", room_type='" + room_type + '\'' +
                ", room_view='" + room_view + '\'' +
                ", room_price=" + room_price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!ID.equals(room.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}
