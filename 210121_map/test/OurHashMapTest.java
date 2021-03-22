import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest extends OurMapTest {
    @BeforeEach
    public void init() {
        map = new OurHashMap<>();

    }

    @Test
    public void test_keyIterator() {
        for (int i = 0; i < 5; i++) {
            map.put(i, "aaa");
            map.put(i * 2, "bbb");
        }

        Iterator iterator = this.map.keyIterator();
        int[] exp = {0, 1, 2, 3, 4, 6, 8};
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
        }
        assertEquals(7, i);
    }

}