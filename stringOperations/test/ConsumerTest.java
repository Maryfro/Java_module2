import operation.IStringOperation;
import operation.OperationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;

import static org.mockito.Mockito.*;

class ConsumerTest {
    OperationContext oc;
    IStringOperation operation;
    Consumer consumer;
    ArrayBlockingQueue queue;
    PrintWriter pw;

    @BeforeEach
    public void init() {
        oc = mock(OperationContext.class);
        operation = mock(IStringOperation.class);
        queue = mock(ArrayBlockingQueue.class);
        pw = mock(PrintWriter.class);
        consumer = new Consumer(queue, pw, oc);
        consumer = spy(consumer);
    }

    @Test
    public void test_handleRawString_regularCase() {
        when(oc.getOperation("upper_case")).thenReturn(operation);
        when(consumer.handleRawString("hello#upper_case")).thenReturn("HELLO");
    }

    @Test
    public void test_handleRawString_wrongFormat() {
        when(oc.getOperation("lower_case")).thenReturn(operation);
        when(consumer.handleRawString("HELLO#lower_case#")).thenReturn("HELLO#lower_case##wrong format");

    }

    @Test
    public void test_handleRawString_wrongOperation() { //does not work
        when(oc.getOperation("upper_case")).thenReturn(operation);
        when(consumer.handleRawString("hello#opper_case")).thenReturn("hello world#opper_case#wrong operation");

    }

    @Test
    public void test_handleRawString_oneWord() {
        when(oc.getOperation("upper_case")).thenReturn(operation);
        when(consumer.handleRawString("hello")).thenReturn("hello#wrong format");

    }

    @Test
    public void test_handleRawString_oneWordAndHash() {
        when(oc.getOperation("upper_case")).thenReturn(operation);
        when(consumer.handleRawString("hello#")).thenReturn("hello##wrong format");
      //  verify(pw, times(1)).println("hello##wrong format");
    }

    @Test
    public void test_handleRawString_wrongResults() {
        when(oc.getOperation("upper_case")).thenReturn(operation);
        when(consumer.handleRawString("hello#")).thenReturn("hesdvx#vxcvsfvmat");
    }

}