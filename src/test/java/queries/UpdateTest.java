package queries;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sarath on 09/10/16.
 */
public class UpdateTest {

    private Update update;

    @Before
    public void setup() {
        update = new Update(new Find("userid", "1adbadfadf1"), "$set");
    }

    @Test
    public void setValue() throws Exception {
        List<Double> coords = Arrays.asList(121.11, 11.121);
        Double[] coordinates = new Double[coords.size()];
        coords.toArray(coordinates);
        Update lastUpdate = update.setValue("lastUpdate", "13adsfasdf").setValue("coordinates", coordinates);

        System.out.println(lastUpdate.query());

    }

}