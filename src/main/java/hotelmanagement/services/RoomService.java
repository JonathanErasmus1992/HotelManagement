package hotelmanagement.services;

import hotelmanagement.domain.Room;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface RoomService {
    public List<Room> getAllRooms();
    public boolean createRoom(int roomNumber, String roomType, String roomView, double roomPrice);
    public boolean updateRoom(int roomNumber, String roomType, String roomView, double roomPrice);
    public boolean deleteRoom(int roomNumber);
}
