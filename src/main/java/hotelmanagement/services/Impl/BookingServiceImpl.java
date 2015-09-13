package hotelmanagement.services.Impl;

import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;
import hotelmanagement.repository.BookingRepo;
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
    public boolean createBooking(String referenceNumber, List<Room> roomList, List<ServicesAndAddOns> servicesAndAddOnsList, Date hireDate) {
        int count = 0;
        boolean blnCreateBooking;

        List<Room> tempRoomList = roomList;
        List<ServicesAndAddOns> tempServicesAndAddOnsList = servicesAndAddOnsList;

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
                    .rooms(tempRoomList)
                    .services_and_addons(tempServicesAndAddOnsList)
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
