import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseMapTest {
    ExerciseMap map = new ExerciseMap();

    @Test
    void findOddNumber_emptyInput() {
        assertThrows(NoSuchElementException.class, () -> {
            map.findOddNumber(new int[]{});
        });
    }

    @Test
    void findOddNumber_singleNumber() {
        assertEquals(5, map.findOddNumber(new int[]{5}));
    }

    @Test
    void findOddNumber_multipleNumbers_oneOccurrence() {
        assertEquals(3, map.findOddNumber(new int[]{1,3,1,1,1}));
    }
    @Test
    void findOddNumber_multipleNumbers_severalOccurrences() {
        assertEquals(3, map.findOddNumber(new int[]{1,3,1,3,3}));
    }


}
