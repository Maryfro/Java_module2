
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest extends OurListTest {

    @BeforeEach
    public void init() {
        list = new ArrayIntegerList();
        listString = new ArrayIntegerList();
    }

}