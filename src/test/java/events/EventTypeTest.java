package events;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sarath on 24/09/16.
 */
public class EventTypeTest {
    EventType e;

    @Before
    public void setup() {
        e = EventType.UNIQUE_PARKING_LOCATIONS;
    }

    @Test
    public void getType() throws Exception {
        assertEquals(e.getType(), "unique_parking_locations");
    }

}