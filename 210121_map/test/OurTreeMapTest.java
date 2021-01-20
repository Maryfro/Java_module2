import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class OurTreeMapTest {
    OurTreeMap<Integer, String> treeMap = new OurTreeMap<>();

    @Test
    public void test_put_get_onePair() {
        treeMap.put(0, "hello");
        assertEquals("hello", treeMap.get(0));
    }


    @Test
    public void test_put_get_replaceValue() {
        treeMap.put(0, "hello");
        treeMap.put(0, "world");
        assertEquals("world", treeMap.get(0));
    }

    @Test
    public void test_put_get_2Elements() {
        treeMap.put(0, "hello");
        treeMap.put(1, "world");
        assertEquals("hello", treeMap.get(0));
        assertEquals("world", treeMap.get(1));
    }


    @Test
    void test_put_get_severalPairs() {
        String[] expected = {"hello", "world", "java", "loop"};
        treeMap.put(0, "hello");
        treeMap.put(1, "world");
        treeMap.put(2, "java");
        treeMap.put(3, "loop");
        for (int i = 0; i < treeMap.size(); i++) {
            assertEquals(expected[i], treeMap.get(i));
        }
    }


    @Test
    public void test_size() {
        for (int i = 0; i < 20; i++) {
            treeMap.put(i, "aaa");
        }
        assertEquals(20, treeMap.size());
    }

    @Test
    void test_get_nullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            treeMap.get(null);
        });

    }

    @Test
    void test_get_noSuchElement_returnNull() {
        assertNull(treeMap.get(1));

    }

    @Test
    void test_get_oneElement() {
        treeMap.put(100, "abracadabra");
        assertEquals("abracadabra", treeMap.get(100));
    }

    @Test
    void test_get_replacedValue() {
        treeMap.put(100, "abracadabra");
        treeMap.put(100, "hello");
        assertEquals("hello", treeMap.get(100));
    }
}