
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest extends OurListTest {

    @BeforeEach
    public void init() {
        list = new ArrayIntegerList();
        listString = new ArrayIntegerList();
    }

    @org.junit.jupiter.api.Test
    void test_addLast_maxCapacity() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        for (int i = 3; i < 17; i++) {
            list.addLast(i);
        }
        assertEquals(17, list.size());
    }

    @org.junit.jupiter.api.Test
    void test_addLast_maxCapacity1() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        for (int i = 3; i < 18; i++) {
            list.addLast(i);
        }
        assertEquals(18, list.size());
        // assertEquals(32, list.source.length);
    }
}