import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurLinkedListTest extends OurListTest {
    @BeforeEach
    public void init() {
        list = new OurLinkedList();
        listString = new OurLinkedList();
    }
}