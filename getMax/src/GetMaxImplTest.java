import static org.junit.jupiter.api.Assertions.*;

class GetMaxImplTest {

    GetMaxImpl gml = new GetMaxImpl();

    @org.junit.jupiter.api.Test
    void getMax_MaxFirst() {
        gml.addLast(220);
        gml.addLast(200);
        gml.addLast(30);
        gml.addLast(25);
        assertEquals(220, gml.getMax());
    }

    @org.junit.jupiter.api.Test
    void getMax_MaxLast() {
        gml.addLast(220);
        gml.addLast(200);
        gml.addLast(30);
        gml.addLast(2502);
        assertEquals(2502, gml.getMax());
    }

    @org.junit.jupiter.api.Test
    void getMax_MaxLMiddle() {
        gml.addLast(220);
        gml.addLast(280);
        gml.addLast(30);
        gml.addLast(25);
        assertEquals(280, gml.getMax());
    }

    @org.junit.jupiter.api.Test
    void getMax_TwoEqualValues() {
        gml.addLast(220);
        gml.addLast(280);
        gml.addLast(20);
        gml.addLast(280);
        assertEquals(280, gml.getMax());
    }

    @org.junit.jupiter.api.Test
    void getMax_EmptyCollection() {
        assertThrows(IndexOutOfBoundsException.class, ()->gml.getMax());
    }

    @org.junit.jupiter.api.Test
    void getMax_OneElement() {
        gml.addLast(0);
        assertEquals(0, gml.getMax());
    }
}