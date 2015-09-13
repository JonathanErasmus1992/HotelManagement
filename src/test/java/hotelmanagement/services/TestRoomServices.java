package hotelmanagement.services;

/**
 * Created by student on 2015/09/12.
 */
import hotelmanagement.App;
import hotelmanagement.domain.Room;
import hotelmanagement.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestRoomServices extends AbstractTestNGSpringContextTests{
    @Autowired
    private RoomService service;
    private Long id;
    private List<Room> rooms;

    @Autowired
    private RoomRepo repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllRooms()
    {
        long count = repository.count();
        rooms = service.getAllRooms();
        Assert.assertTrue(rooms.size() == count);
    }

    @Test
    public void testCreateRoom()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.createRoom(0, "Double", "Standard", 500));
    }

    @Test
    public void testUpdateRoom()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertFalse(service.updateRoom(0, "Single", "Standard", 350));
    }

    @Test void testDeleteRoom()
    {
        //Must change the room number field to check if test passes or fails as
        //duplicate email addresses are not allowed
        //switch between assertFalse and assertTrue
        Assert.assertTrue(service.deleteRoom(0));
    }
}
