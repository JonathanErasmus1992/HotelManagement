package hotelmanagement.services.Impl;

import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.repository.BookingRepo;
import hotelmanagement.repository.RoomRepo;
import hotelmanagement.repository.ServicesAndAddOnsRepo;
import hotelmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingRepo repositoryBooking;
    RoomRepo repositoryRoom;
    ServicesAndAddOnsRepo repositoryServicesAndAddOns;

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> allBookings = new ArrayList<Booking>();

        Iterable<Booking> bookings = repositoryBooking.findAll();
        for (Booking booking : bookings) {
            allBookings.add(booking);
        }
        return allBookings;
    }

    @Override
    public boolean createBooking(String referenceNumber, String rooms, String servicesAndExtras, Date hireDate) {
        int count = 0;
        boolean blnCreateBooking;

        Iterable<Booking> bookings = repositoryBooking.findAll();
        for (Booking booking : bookings) {
           if(booking.getReferenceNumber().equalsIgnoreCase(referenceNumber))
           {
               count = count + 1;
           }
        }
        if(count == 0)
        {
            Booking booking = new Booking.Builder(referenceNumber)
                    .rooms(rooms)
                    .services_and_addons(servicesAndExtras)
                    .hireDate(hireDate)
                    .build();
            repositoryBooking.save(booking);

            blnCreateBooking = true;
        }
        else
        {
            blnCreateBooking = false;
        }

        return blnCreateBooking;
    }

    @Override
    public boolean updateBooking(String referenceNumber, String rooms, String servicesAndExtras)
    {
        boolean blnBookingUpdated = false;

        Iterable<Booking> bookings = repositoryBooking.findAll();
        for (Booking booking : bookings) {
            if(booking.getReferenceNumber().equalsIgnoreCase(referenceNumber))
            {
                Booking newBooking = new Booking.Builder(booking.getReferenceNumber())
                        .ID(booking.getID())
                        .rooms(rooms)
                        .services_and_addons(servicesAndExtras)
                        .hireDate(booking.getDate())
                        .build();
                repositoryBooking.save(newBooking);

                blnBookingUpdated = true;
            }
        }

        return blnBookingUpdated;
    }

    @Override
    public boolean deleteBooking(String referenceNumber) {
        Long bookingID = 0L;
        boolean blnDeleteCustomerBooking = false;

        Iterable<Booking> bookings = repositoryBooking.findAll();
        for (Booking booking : bookings) {
            if(booking.getReferenceNumber().equalsIgnoreCase(referenceNumber))
            {
                bookingID = booking.getID();
                blnDeleteCustomerBooking = true;
            }
        }
        if(blnDeleteCustomerBooking == true)
        {
            repositoryBooking.delete(bookingID);
        }
        return blnDeleteCustomerBooking;
    }
}
