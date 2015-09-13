package hotelmanagement.services.Impl;

import hotelmanagement.conf.RoomFactory;
import hotelmanagement.domain.Room;
import hotelmanagement.repository.RoomRepo;
import hotelmanagement.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepo repositoryRoom;

    @Override
    public List<Room> getAllRooms() {
        List<Room> allRooms = new ArrayList<Room>();

        Iterable<Room> rooms = repositoryRoom.findAll();
        for (Room user : rooms) {
            allRooms.add(user);
        }
        return allRooms;
    }

    @Override
    public boolean createRoom(int roomNumber, String roomType, String roomView, double roomPrice) {
        int count = 0;
        boolean blnCreateRoom;
        Iterable<Room> rooms = repositoryRoom.findAll();
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber)
            {
                count = count + 1;
            }
        }

        if (count == 0)
        {
            Room room = RoomFactory.createRoom(roomNumber, roomType, roomView, roomPrice);
            repositoryRoom.save(room);
            blnCreateRoom = true;
        }
        else
        {
            //False is generated if the room exists already
            blnCreateRoom = false;
        }
        return blnCreateRoom;
    }

    @Override
    public boolean updateRoom(int roomNumber, String roomType, String roomView, double roomPrice) {
        boolean blnRoomUpdate = false;
        Long ID = 0L;
        Iterable<Room> rooms = repositoryRoom.findAll();
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber)
            {
                blnRoomUpdate = true;
                ID = room.getID();
            }
        }

        if (blnRoomUpdate == true)
        {
            Room room = repositoryRoom.findOne(ID);
            Room newRoom = new Room.Builder(room.getRoomNumber())
                    .ID(ID)
                    .room_type(roomType)
                    .room_view(roomView)
                    .room_price(roomPrice)
                    .build();
            repositoryRoom.save(newRoom);
        }

        return blnRoomUpdate;
    }

    @Override
    public boolean deleteRoom(int roomNumber) {
        boolean blnRoomDelete = false;
        Long ID = 0L;
        Iterable<Room> rooms = repositoryRoom.findAll();
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber)
            {
                blnRoomDelete = true;
                ID = room.getID();
            }
        }

        if (blnRoomDelete == true)
        {
            repositoryRoom.delete(ID);
        }

        return blnRoomDelete;
    }
}
