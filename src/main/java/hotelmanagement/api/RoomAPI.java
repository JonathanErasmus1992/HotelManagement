package hotelmanagement.api;

/**
 * Created by student on 2015/09/14.
 */
import hotelmanagement.domain.Room;
import hotelmanagement.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/room/**")
public class RoomAPI {
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Room>> getAllRooms()
    {
        List<Room> roomList = roomService.getAllRooms();

        return new ResponseEntity<List<Room>>(roomList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createRoom(@RequestParam int roomNumber,
                                              @RequestParam String roomType,
                                              @RequestParam String roomView,
                                              @RequestParam double roomPrice)
    {
        boolean blnRoomCreated = false;

        blnRoomCreated = roomService.createRoom(roomNumber, roomType, roomView, roomPrice);

        return new ResponseEntity<Boolean>(blnRoomCreated, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateRoom(@RequestParam int roomNumber,
                                              @RequestParam String roomType,
                                              @RequestParam String roomView,
                                              @RequestParam double roomPrice)
    {
        boolean blnRoomUpdated = false;

        blnRoomUpdated = roomService.updateRoom(roomNumber, roomType, roomView, roomPrice);

        return new ResponseEntity<Boolean>(blnRoomUpdated, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteRoom(@RequestParam int roomNumber)
    {
        boolean blnRoomDeleted = false;

        blnRoomDeleted = roomService.deleteRoom(roomNumber);

        return new ResponseEntity<Boolean>(blnRoomDeleted, HttpStatus.OK);
    }

}
