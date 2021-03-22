
import org.junit.jupiter.api.BeforeEach;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Iterator;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest extends OurListTest {

    @BeforeEach
    public void init() {
        //list = new ArrayIntegerList();
        list = mock(ArrayIntegerList.class);
        listString = new ArrayIntegerList();
    }


    @org.junit.jupiter.api.Test
    void test_removeById_size_usingMockito() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3); //how to test void methods?
        when(list.removeById(1)).thenReturn(2);
        list.size();
        verify(list, times(1)).size();
    }

    @org.junit.jupiter.api.Test
    void test_get_exception_usingMockito() { //does not pass
        when(list.get(0)).thenThrow(new NullPointerException());
        verify(list, times(1)).get(0);
    }

    @org.junit.jupiter.api.Test
    void test_add_get_usingMockito() {
        doNothing().when(list).addLast(isA(Integer.class));
        when(list.removeById(1)).thenReturn(2);
        list.get(0);
        verify(list, times(1)).get(0);
    }

    @org.junit.jupiter.api.Test
    void test_add_usingMockito() {
        doNothing().when(list).addLast(isA(Integer.class));
        list.addLast(0);
        verify(list, times(1)).addLast(0);
    }

}