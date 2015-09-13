package hotelmanagement.domain;

import hotelmanagement.conf.RoomFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by student on 2015/05/05.
 */
public class TestRoomFactory {
    private Room room;
    private Room newRoom;
    @Before
    public void setUp()
    {
        room = RoomFactory.createRoom( 03, "Double", "Ocean", 2500.00);
    }
    @Test
    public void testCreate() throws Exception
    {
        Assert.assertEquals(03, room.getRoomNumber());
    }
    @Test
    public void testUpdate() throws Exception
    {
        newRoom = new Room
                .Builder(room.getRoomNumber())
                .copy(room)
                .room_price(2400.00)
                .build();
        Assert.assertEquals(03, newRoom.getRoomNumber());
        Assert.assertEquals(2400.00, newRoom.getRoomPrice());
    }
    @After
    public void tearDown()
    {

    }
}
