package FootballClubsAndFindMissingNumber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    public void test_findMissingNumber_withSum() {
        MissingNumber mn = new MissingNumber(1, 100);
        int[] arr = mn.composeArrayForInput();
        assertFalse(Arrays.asList(arr).contains(mn.findMissingNumber_withSum(arr)));
        assertEquals(mn.missingNumber, mn.findMissingNumber_withSum(arr));
    }

    @Test
    public void test_findMissingNumber_withTwolists() {
        MissingNumber mn = new MissingNumber(1, 100);
        int[] arr = mn.composeArrayForInput();
        assertFalse(Arrays.asList(arr).contains(mn.findMissingNumber_withTwoLists(arr)));
        assertEquals(mn.missingNumber, mn.findMissingNumber_withTwoLists(arr));
    }

    @Test
    public void test_findMissingNumber_binarySearch() {
        MissingNumber mn = new MissingNumber(1, 100);
        int[] arr = mn.composeArrayForInput();
        assertFalse(Arrays.asList(arr).contains(mn.findMissingNumber_binarySearch(arr)));
        assertEquals(mn.missingNumber, mn.findMissingNumber_binarySearch(arr));
    }

}