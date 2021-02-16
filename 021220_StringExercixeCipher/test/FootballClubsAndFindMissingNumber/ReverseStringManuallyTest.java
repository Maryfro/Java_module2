package FootballClubsAndFindMissingNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringManuallyTest {

    ReverseStringManually rsm = new ReverseStringManually();

    @Test
    public void reverseString_severalLetters(){
     assertEquals("arbadacarba", rsm.reverseString("abracadabra"));
    }

    @Test
    public void reverseString_emptyString(){
        assertEquals("", rsm.reverseString(""));
    }

    @Test
    public void reverseString_oneChar(){
        assertEquals("A", rsm.reverseString("A"));
    }

}