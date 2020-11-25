
import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest {
    ArrayIntegerList list = new ArrayIntegerList();

    {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
    }

    @org.junit.jupiter.api.Test
    void test_addLast() {
        assertEquals(3, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void test_addLast_maxCapacity() {
        for (int i = 3; i < 18; i++) {
            list.addLast(i);
        }
        assertEquals(17, list.get(17));
    }

    @org.junit.jupiter.api.Test
    void test_addLast_maxCapacity1() {
        for (int i = 3; i < 18; i++) {
            list.addLast(i);
        }
        assertEquals(32, list.source.length);
    }

    @org.junit.jupiter.api.Test
    void test_get_nonNegativeElement() {
        assertEquals(1, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void test_removeById() {
        list.removeById(1);
        assertEquals(3, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void test_set() {
        list.set(0, 10);
        assertEquals(10, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void test_size() {
        assertEquals(3, list.size(), "checking list size");
    }
}