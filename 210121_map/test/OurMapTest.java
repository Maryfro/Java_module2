import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

abstract class OurMapTest {
    OurMap<Integer, String> map;

    @Test
    public void test_findPair_and_put_get() {
        map.put(0, "hello");
        assertEquals("hello", map.get(0));
    }


    @Test
    public void test_findPair_and_put_get_replaceValue() {
        map.put(0, "hello");
        map.put(0, "world");
        // System.out.println(map);
        assertEquals("world", map.get(0));
    }

    @Test
    public void test_findPair_and_put_get_severalPairs() {
        String[] expected = {"hello", "world", "java", "java"};
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        // System.out.println(map);
        for (int i = 0; i < map.size(); i++) {
            assertEquals(expected[i], map.get(i));
        }
    }

    @Test
    public void test_size_resize() {
        for (int i = 0; i < 20; i++) {
            map.put(i, "aaa");
        }
        // System.out.println(map);
        assertEquals(20, map.size());
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
    }

    @Test
    public void test_remove_fromMiddle() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        map.put(5, "code");
        String res = map.remove(1);
        // System.out.println(res);
        assertEquals("world", res);
        assertEquals(4, map.size());
    }

    @Test
    public void test_remove_oneElement() {
        map.put(0, "hello");

        String res = map.remove(0);
        assertEquals("hello", res);
        assertEquals(0, map.size());
        assertNull(map.get(0));
    }

    @Test
    public void test_remove_fromHead() {
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "java");
        map.put(5, "code");
        String res = map.remove(0);
        //  System.out.println(res);
        assertEquals("hello", res);
        assertEquals(4, map.size());
    }

    @Test
    public void test_remove_resize() {
        for (int i = 0; i < 14; i++) {
            map.put(i, "aaa");
            assertEquals("aaa", map.get(i));
        }
        assertEquals("aaa", map.get(13));
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

    @Test
    void test_valueIterator() {
        for (int i = 0; i < 5; i++) {
            map.put(i, "aaa");
            map.put(i * 2, "bbb");
        }
        String[] exp = {"bbb", "aaa", "aaa", "aaa", "aaa", "bbb", "bbb"};
        Iterator iterator = map.valueIterator();
        int size = map.size();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
        }
        assertEquals(7, i);
    }

    @Test
    void test_get_replacedValue() {
        map.put(100, "abracadabra");
        map.put(100, "hello");
        assertEquals("hello", map.get(100));
    }

    @Test
    void test_get_nullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            map.get(null);
        });

    }

    @Test
    void test_put_nullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            map.put(null, "!");
        });

    }

    @Test
    void test_get_noSuchElement_returnNull() {
        assertNull(map.get(1));

    }

    @Test
    void test_remove_emptyMap() {
        assertNull(map.remove(0));
    }

    @Test
    void test_contains_trueCase() {
        map.put(666, "@");
        assertTrue(map.containsKey(666));
    }

    @Test
    void test_contains_falseCase() {
        assertFalse(map.containsKey(666));
    }
}