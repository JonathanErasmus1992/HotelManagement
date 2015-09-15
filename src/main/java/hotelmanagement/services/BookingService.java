package hotelmanagement.services;

import hotelmanagement.domain.Booking;
import hotelmanagement.domain.Room;
import hotelmanagement.domain.ServicesAndAddOns;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public interface BookingService {
    public List<Booking> getAllBookings();
    public boolean createBooking(String referenceNumber, List<Room>roomList, List<ServicesAndAddOns> servicesAndAddOnsList, Date hireDate);
    public boolean updateBooking(String referenceNumber, int roomNumber, int SEID);
    public boolean deleteBooking(String referenceNumber);
}
/*
    No updating just remove room from room list
    Same with Add Ons of the booking
 */
