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
    public boolean updateBooking(String referenceNumber, int roomNumber, int SEID)
    {
        Long bookingID = 0L;
        boolean blnUpdateCustomerBooking = false;
        boolean blnRoomFound = false;
        boolean blnServAndExtraFound = false;
        int indexRoom = -1;
        int indexServiceAndExtra = -1;

        List<Room> rooms = new ArrayList<Room>();
        List<ServicesAndAddOns> servicesAndAddOnses = new ArrayList<ServicesAndAddOns>();

        Date hireDate = new Date();

        Iterable<Booking> bookings = repositoryBooking.findAll();
        for (Booking booking : bookings) {
            if(booking.getReferenceNumber().equalsIgnoreCase(referenceNumber))
            {
                bookingID = booking.getID();
                rooms = booking.getRooms();
                servicesAndAddOnses = booking.getServicesAndAddOns();
                hireDate = booking.getDate();
            }
        }

        for (Room room: rooms)
        {
            if(room.getRoomNumber() == roomNumber)
            {
                blnRoomFound = true;
            }
        }

        for (ServicesAndAddOns servicesAndAddOn: servicesAndAddOnses)
        {
            if(servicesAndAddOn.getServExtraID() == SEID)
            {
                blnServAndExtraFound = true;
            }
        }

        if(blnRoomFound == true)
        {
            for(int i = 0; i < rooms.size(); i++)
            {
                if(rooms.get(i).getRoomNumber() == roomNumber)
                {
                    indexRoom = i;
                }
            }

            rooms.remove(indexRoom);
        }

        if(blnServAndExtraFound == true)
        {
            for(int i = 0; i < servicesAndAddOnses.size(); i++)
            {
                if(servicesAndAddOnses.get(i).getServExtraID() == SEID)
                {
                    indexServiceAndExtra = i;
                }
            }

            servicesAndAddOnses.remove(indexServiceAndExtra);
        }

        if ((blnRoomFound == true) || (blnServAndExtraFound == true))
        {
            blnUpdateCustomerBooking = true;
        }

        if (blnUpdateCustomerBooking == true)
        {
            Booking newBooking = new Booking.Builder(referenceNumber)
                    .ID(bookingID)
                    .rooms(rooms)
                    .services_and_addons(servicesAndAddOnses)
                    .build();
            repositoryBooking.save(newBooking);
        }

        return blnUpdateCustomerBooking;
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
