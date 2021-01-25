import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

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
        for (int i = 0; i < 3; i++) {
            map.put(i, "aaa");

        }
        Iterator iterator = this.map.keyIterator();
        ArrayList<Integer> exp = new ArrayList<>();
        Collections.addAll(exp, 0, 1, 2);
        ArrayList<Integer> actual = new ArrayList<>();
        while (iterator.hasNext()) {
            actual.add((Integer) iterator.next());
        }
        assertEquals(exp, actual);
    }

    @Test
    public void test_keyIterator_anotherTree() {
        map.put(33, "zz");
        map.put(-5, "yy");
        map.put(0, "xx");
        map.put(12, "*");
        Iterator iterator = this.map.keyIterator();
        ArrayList<Integer> exp = new ArrayList<>();
        Collections.addAll(exp, -5, 0, 12, 33);
        ArrayList<Integer> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            actual.add((Integer) iterator.next());
        }
        assertEquals(exp, actual);
    }

    @Test
    public void test_valueIterator() {
        for (int i = 0; i < 3; i++) {
            map.put(i, "aaa");

        }
        Iterator iterator = this.map.valueIterator();
        ArrayList<String> exp = new ArrayList<>();
        Collections.addAll(exp, "aaa", "aaa", "aaa");
        ArrayList<String> actual = new ArrayList<>();
        while (iterator.hasNext()) {
            actual.add((String) iterator.next());
        }
        assertEquals(exp, actual);
    }

    @Test
    public void test_valueIterator_anotherTree() {
        map.put(33, "zz");
        map.put(-5, "yy");
        map.put(0, "xx");
        map.put(12, "*");
        Iterator iterator = this.map.valueIterator();
        ArrayList<String> exp = new ArrayList<>();
        Collections.addAll(exp, "yy", "xx", "*", "zz");
        ArrayList<String> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            actual.add((String) iterator.next());
        }
        assertEquals(exp, actual);
    }

    @Test
    public void test_valueIterator_exception() {
        Iterator iterator = this.map.valueIterator();
        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }


}