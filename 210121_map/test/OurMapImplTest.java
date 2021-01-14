import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OurMapImplTest {
    OurMapImpl<Integer, String> map = new OurMapImpl<>();

    @Test
    public void test_findPair_and_put_get() {
        map.put(0, "hello");
        System.out.println(map);
        assertEquals("hello", map.get(0));
    }


    @Test
    public void test_findPair_and_put_get_replaceValue() {
        map.put(0, "hello");
        map.put(0, "world");
        System.out.println(map);
        assertEquals("world", map.get(0));
    }

    @Test
    public void test_findPair_and_put_get_severalPairs() {
        String[] expected = {"hello", "world", "java", "java"};
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        System.out.println(map);
        for (int i = 0; i < map.size(); i++) {
            assertEquals(expected[i], map.get(i));
        }
    }

    @Test
    public void test_size_resize() {
        for (int i = 0; i < 20; i++) {
            map.put(i, "aaa");
        }
        System.out.println(map);
        assertEquals(20, map.size());
    }

    @Test
    public void test_remove_fromTail() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        String res = map.remove(3);
        System.out.println(res);
        assertEquals("java", res);
        assertEquals(3, map.size());
    }

    @Test
    public void test_remove_fromMiddle() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        map.put(5, "code");
        String res = map.remove(1);
        System.out.println(res);
        assertEquals("world", res);
        assertEquals(4, map.size());
    }

    @Test
    public void test_remove_fromHead() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        map.put(5, "code");
        String res = map.remove(0);
        System.out.println(res);
        assertEquals("hello", res);
        assertEquals(4, map.size());
    }

    @Test
    public void test_remove_resize() {
        for (int i = 0; i < 14; i++) {
            map.put(i, "aaa");
            assertEquals("aaa", map.get(i));
        }
        // System.out.println(map);
        assertEquals("aaa", map.get(13));
    }

    @Test
    public void test_keyIterator() {
        for (int i = 0; i < 5; i++) {
            map.put(i, "aaa");
            map.put(i * 2, "bbb");
        }
       // map.keyIterator();
        int[] exp = {0, 1, 2, 3, 4, 6, 8};
   while (map.keyIterator().hasNext()) {
            System.out.println(map.keyIterator().next());
            assertEquals(0, map.keyIterator().next());
            System.out.println(map.keyIterator().next());
            // assertEquals(1, map.keyIterator().next());
            System.out.println(map.keyIterator().next());
            //assertEquals(2, map.keyIterator().next());
            System.out.println(map.keyIterator().next());
           // assertEquals(3, map.keyIterator().next());
            System.out.println(map.keyIterator().next());
           // assertEquals(4, map.keyIterator().next());
           // assertEquals(6, map.keyIterator().next());
          //  assertEquals(8, map.keyIterator().next());
        }

    }
}


