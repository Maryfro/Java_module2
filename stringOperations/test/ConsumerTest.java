import operation.IStringOperation;
import operation.OperationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ConsumerTest {
    OperationContext oc;
    IStringOperation operation;
    Consumer consumer;
    ArrayBlockingQueue<String> queue;
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
        when(operation.operate("hello")).thenReturn("HeLlO");
        when(oc.getOperation("beliberda_operation")).thenReturn(operation);

        String res = consumer.handleRawString("hello#beliberda_operation");
        assertEquals("HeLlO", res);
    }

    @Test
    public void test_handleRawString_wrongFormat() {
        String res = consumer.handleRawString("hello world#lower_case#param#");
        assertEquals("hello world#lower_case#param#" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }

    @Test
    public void test_handleRawString_oneWordAndHash() {
        String res = consumer.handleRawString("hello#");
        assertEquals("hello#" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }

    @Test
    public void test_handleRawString_wrongOperation() {

        when(oc.getOperation("beliberda_operation")).thenReturn(null);
        String res = consumer.handleRawString("hello#beliberda_operation");
        assertEquals("hello#beliberda_operation" + Consumer.SEPARATOR + Consumer.WRONG_OPERATION, res);
    }

    @Test
    public void test_handleRawString_oneWord() {
        String res = consumer.handleRawString("hello");
        assertEquals("hello" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }


}