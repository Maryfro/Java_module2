
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class OurListTest {
    OurList<Integer> list;
    OurList<String> listString;


    @org.junit.jupiter.api.Test
    void test_size() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.size(), "checking list size");
    }

    @org.junit.jupiter.api.Test
    void testGet_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveById_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeById(0);
        });
    }

    @org.junit.jupiter.api.Test
    void testSet_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, 10);
        });
    }


    @org.junit.jupiter.api.Test
    void test_addLast() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void test_addLast_CorrectOrder() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        int[] numbers = new int[]{1, 2, 3};
        for (int i = 0; i < list.size(); i++) {
            assertEquals(numbers[i], list.get(i));
        }

    }



    @org.junit.jupiter.api.Test
    void test_get_nonNegativeElement() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void test_get_Exception() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(10);
        });
    }

    @org.junit.jupiter.api.Test
    void test_removeById_LastIndex() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeById(2);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @org.junit.jupiter.api.Test
    void test_removeById_IndexZero() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        //assertEquals(1, list.removeById(0));

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void test_removeById_IndexMiddle() {
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeById(3);

        assertEquals(5, list.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(i, list.get(i));
        }

        for (int i = 3; i < list.size(); i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void test_removeById_IndexLast() {
        for (int i = 0; i < 16; i++) {
            list.addLast(i);
        }
        assertEquals(15, list.removeById(15));
    }

    @org.junit.jupiter.api.Test
    void test_set_IndexZero() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.set(0, 10);
        assertEquals(10, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void test_set_IndexLast() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.set(2, 10);
        assertEquals(10, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void test_set_IndexIntermediate() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.set(1, 10);
        assertEquals(10, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void test_clear_EmptyList() {
        list.clear();
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void test_clear_NonEmptyList() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void test_universal() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeById(2);//{1,2}
        list.set(1, 10);//{1,10}
        list.addLast(-10);//{1, 10, -10}
        list.removeById(0); //{ 10, -10}
        int[] expected = new int[]{10, -10};

        assertEquals(2, list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected[i], list.get(i));
        }

    }

    @org.junit.jupiter.api.Test
    void test_universal_String() {
        listString.addLast("abra");
        listString.addLast("ca");
        listString.addLast("da");
        listString.removeById(2);
        listString.set(1, "cadabra");
        listString.addLast("!");
        listString.removeById(2);
        String[] expected = new String[]{"abra", "cadabra"};
        assertEquals(2, listString.size());
        for (int i = 0; i < listString.size(); i++) {
            assertEquals(expected[i], listString.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void test_contains_trueCase() {
        listString.addLast("abra");
        listString.addLast("ca");
        listString.addLast("da");
        listString.addLast("bra");
        assertTrue(listString.contains("ca"));
    }

    @org.junit.jupiter.api.Test
    void test_contains_falseCase() {
        listString.addLast("abra");
        listString.addLast("ca");
        listString.addLast("da");
        listString.addLast("bra");
        assertFalse(listString.contains("!"));
    }

    @org.junit.jupiter.api.Test
    void test_remove_emptyList() {
        assertFalse(list.remove(15));
    }
    @org.junit.jupiter.api.Test
    void test_remove_singleElement() {
        listString.addLast("Hello");
        assertTrue(listString.remove("Hello"));
        assertEquals(0, listString.size());
    }

    @org.junit.jupiter.api.Test
    void test_removeById_singleElement() {
        listString.addLast("Hello");
        assertEquals( "Hello",listString.removeById(0));
        assertEquals(0, listString.size());
    }

    @org.junit.jupiter.api.Test
    void test_remove_trueCase() {
        list.addLast(14);
        assertTrue(list.remove(14));
    }

    @org.junit.jupiter.api.Test
    void test_remove_falseCase() {
        list.addLast(14);
        assertFalse(list.remove(10));
    }

    @org.junit.jupiter.api.Test
    void test_forwardIterator_emptyList() {
        Iterator<String> forwardIterator = listString.forwardIterator();
        assertFalse(forwardIterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            forwardIterator.next();
        });
    }
    @org.junit.jupiter.api.Test
    void test_forwardIterator_oneElement() {
        String[] expected = {"Hello"};
        Iterator<String> forwardIterator = listString.forwardIterator();
        listString.addLast("Hello");
        int i = 0;
        while (forwardIterator.hasNext()) {
            assertEquals(expected[i++],
                    forwardIterator.next());
        }
        assertEquals(1, i);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            forwardIterator.next();
        });
    }

    @org.junit.jupiter.api.Test
    void test_forwardIterator_severalElements() {
        String[] expected = {"Hello", "world", "java", "code"};
        Iterator<String> forwardIterator = listString.forwardIterator();
        listString.addLast("Hello");
        listString.addLast("world");
        listString.addLast("java");
        listString.addLast("code");
        int i = 0;
        while (forwardIterator.hasNext()) {
            assertEquals(expected[i++],
                    forwardIterator.next());
        }
        assertEquals(4, i);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            forwardIterator.next();
        });
    }


    @org.junit.jupiter.api.Test
    void test_backwardIterator_emptyList() {
        Iterator<String> backwardIterator = listString.backwardIterator();
        assertFalse(backwardIterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            backwardIterator.next();
        });
    }
    @org.junit.jupiter.api.Test
    void test_backwardIterator_oneElement() {
        String[] expected = {"Hello"};
        Iterator<String> backwardIterator = listString.backwardIterator();
        listString.addLast("Hello");
        int i = 0;
        while (backwardIterator.hasNext()) {
            assertEquals(expected[i++],
                    backwardIterator.next());
        }
        assertEquals(1, i);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            backwardIterator.next();
        });
    }

    @org.junit.jupiter.api.Test
    void test_backwardIterator_severalElements() {
        String[] expected = {"code", "java", "world", "Hello"};
        Iterator<String> backwardIterator = listString.backwardIterator();
        listString.addLast("Hello");
        listString.addLast("world");
        listString.addLast("java");
        listString.addLast("code");
        int i = 0;
        while (backwardIterator.hasNext()) {
            assertEquals(expected[i++],
                    backwardIterator.next());
        }
        assertEquals(0, i);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            backwardIterator.next();
        });
    }


    @org.junit.jupiter.api.Test
    void test_remove_singleNullElement() {
        list.addLast(null);
        assertTrue(list.remove(null));
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void test_contains_singleNullElement() {
        list.addLast(null);
        assertTrue(list.contains(null));
    }
    
}