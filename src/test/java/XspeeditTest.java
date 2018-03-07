import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class XspeeditTest {

    @Test
    public void robot_test_actuel() {
        final String articles = "163841689525773";
        Box boxActuel = new Box(Arrays.stream(articles.split("\\B"))
                .map(s -> new Item(Integer.valueOf(s)))
                .collect(Collectors.toList()));
        final String expected = "Robot actuel    : 163/8/41/6/8/9/52/5/7/73 => 10 cartons utilises";
        final String current = Robot.getActuel(boxActuel);
        assertEquals(expected, current);
    }
}
