import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

abstract class OurSetTest {

    OurSet<Integer> set;

    @Test
    public void test_add_trueCase_iterator() {
        assertTrue(set.add(5));
        assertEquals(5, set.iterator().next());
    }

    @Test
    public void test_add_falseCase_size() {
        set.add(5);
        assertFalse(set.add(5));
        assertEquals(1, set.size());
    }

    @Test
    public void test_add_severalElements_size() {
        set.add(5);
        set.add(-5);
        set.add(121);
        assertFalse(set.add(5));
        assertFalse(set.add(-5));
        assertFalse(set.add(121));
        assertTrue(set.add(34));
        assertTrue(set.add(0));
        assertEquals(5, set.size());
    }

    @Test
    public void test_remove_falseCase_size() {
        assertFalse(set.remove(2));
        assertEquals(0, set.size());
    }

    @Test
    public void test_remove_trueCase_iterator() {
        set.add(2);
        assertTrue(set.remove(2));
        assertFalse(set.iterator().hasNext());
    }


    @Test
    public void test_add_and_remove_severalElements_size() {
        set.add(5);
        set.add(-5);
        set.add(121);
        assertTrue(set.remove(5));
        assertTrue(set.remove(-5));
        assertFalse(set.remove(-5));
        assertFalse(set.remove(34));
        assertFalse(set.remove(0));
        assertEquals(1, set.size());
    }

    @Test
    public void test_size() {
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        assertEquals(20, set.size());
    }

    @Test
    public void test_contains_trueCase() {
        int[] exp = {5, -5, 0};
        for (int i = 0; i < exp.length; i++) {
            set.add(exp[i]);
            assertTrue(set.contains(exp[i]));
        }
    }

    @Test
    public void test_contains_falseCase() {
        int[] exp = {5, -5, 0};
        for (int i = 0; i < exp.length; i++) {
            assertFalse(set.contains(exp[i]));
        }
    }

    @Test
    public void test_addAll_size_contains() {
        OurHashSet<Integer> another = new OurHashSet<>();
        another.add(2);
        another.add(-5);
        set.add(101);
        set.add(-86);
        set.addAll(another);
        assertEquals(4, set.size());
        assertTrue(set.contains(2));
        assertTrue(set.contains(-5));
        assertTrue(set.contains(101));
        assertTrue(set.contains(-86));
    }

    @Test
    public void test_retainAll_size_contains() {
        OurHashSet<Integer> another = new OurHashSet<>();
        another.add(2);
        another.add(7);
        set.add(7);
        set.add(2);
        set.add(-5);
        set.retainAll(another);
        assertEquals(2, set.size());
        assertTrue(set.contains(2));
        assertTrue(set.contains(7));
        assertFalse(set.contains(101));
        assertFalse(set.contains(-86));
    }

    @Test
    public void test_removeAll_size_contains() {
        OurHashSet<Integer> another = new OurHashSet<>();
        another.add(2);
        another.add(-5);
        another.add(7);
        set.add(101);
        set.add(-86);
        set.add(7);
        set.add(2);
        set.removeAll(another);
        assertEquals(2, set.size());
        assertFalse(set.contains(2));
        assertFalse(set.contains(7));
        assertTrue(set.contains(101));
        assertTrue(set.contains(-86));
    }

    @Test
    public void test_keyIterator() {
        for (int i = 0; i < 5; i++) {
            set.add(i);
            set.add(i * 2);
        }

        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
        }
        assertEquals(7, i);
    }


}