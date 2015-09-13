package hotelmanagement.repository;

import hotelmanagement.App;

import hotelmanagement.domain.Room;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/09/09.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestRoomRepo extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    RoomRepo repository;
    @Test
    public void testCreate() throws Exception {
        Room room = new Room.Builder(2)
                .room_type("Double Bed")
                .room_view("Standard")
                .room_price(450.00)
                .build();
        repository.save(room);
        id = room.getID();
        Assert.assertNotNull(room);
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws  Exception {
        Room room = repository.findOne(id);
        Assert.assertEquals(2, room.getRoomNumber());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws  Exception {
        Room room =   repository.findOne(id);
        Room newRoom = new Room.Builder(room.getRoomNumber())
                .ID(id)
                .room_type("Double Bed")
                .room_view("Standard")
                .room_price(400.00)
                .build();
        repository.save(newRoom);

        Room updateRoom = repository.findOne(id);
        Assert.assertEquals(400.00, updateRoom.getRoomPrice(), 2);
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws  Exception {
        Room room = repository.findOne(id);
        repository.delete(room);
        Room newRoom = repository.findOne(id);
        Assert.assertNull(newRoom);
    }
}
