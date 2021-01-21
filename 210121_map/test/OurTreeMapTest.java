import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurTreeMapTest extends OurMapTest {
    @BeforeEach
    public void init() {
        map = new OurTreeMap<>();

    }

    @Test
    public void test_remove_fromHead() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        map.put(4, "code");
        String res = map.remove(0);
        //  System.out.println(res);
        assertEquals("hello", res);
        assertEquals(4, map.size());
        String[] exp = {null, "world", "java", "java", "code"};
        for (int i = 0; i < map.size(); i++) {
            assertEquals(exp[i], map.get(i));
        }
    }

    @Test
    public void test_remove_fromMiddle() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        map.put(4, "code");
        String res = map.remove(1);
        assertEquals("world", res);
        assertEquals(4, map.size());

        String[] exp = {"hello", null, "java", "java", "code"};
        for (int i = 0; i < map.size(); i++) {
            assertEquals(exp[i], map.get(i));
        }
    }

    @Test
    public void test_remove_fromTail() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        String res = map.remove(3);
        //  System.out.println(res);
        assertEquals("java", res);
        assertEquals(3, map.size());

        String[] exp = {"hello", "world", "java", null};
        for (int i = 0; i < map.size(); i++) {
            assertEquals(exp[i], map.get(i));
        }
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
        assertEquals(exp[i], iterator.next());
        }
    }


}