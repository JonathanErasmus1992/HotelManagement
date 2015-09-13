package hotelmanagement.conf;


import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Dates;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
public class BookingFactory {

    public static Booking createBooking(String ref_num,
                                        List<Room> rooms,
                                        List<ServicesAndAddOns> servicesAndAddOnslist,
                                        Date hireDate)
    {
        Booking booking = new Booking
                .Builder(ref_num)
                .rooms(rooms)
                .services_and_addons(servicesAndAddOnslist)
                .hireDate(hireDate)
                .build();
        return booking;
    }

}
